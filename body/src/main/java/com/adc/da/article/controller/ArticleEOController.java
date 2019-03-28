package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.FileDownLoad;
import com.adc.da.FileUpLoad;
import com.adc.da.admin.service.LexiconEOService;
import com.adc.da.article.entity.ImgPathEO;
import com.adc.da.article.entity.vo.HistoryVo;
import com.adc.da.article.service.ImgPathEOService;
import com.adc.da.article.service.LabelEOService;
import com.adc.da.personInfo.entity.PersonInfoEO;
import com.adc.da.personInfo.service.PersonInfoEOService;
import com.adc.da.util.utils.UUID;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.article.entity.ArticleEO;
import com.adc.da.article.page.ArticleEOPage;
import com.adc.da.article.service.ArticleEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/article/article")
@Api(description = "|ArticleEO|")
public class ArticleEOController extends BaseController<ArticleEO>{

    private static final Logger logger = LoggerFactory.getLogger(ArticleEOController.class);

    @Autowired
    private ArticleEOService articleEOService;

    @Autowired
    private LabelEOService labelEOService;

    @Autowired
    private LexiconEOService lexiconEOService;

    @Autowired
    private ImgPathEOService imgPathEOService;

    @Autowired
    private PersonInfoEOService personInfoEOService;

    /**
     *      1、主页查询条件有：修改时间，标题模糊查询，类型，发布状态（已发布）
     *      2、我的文章查询条件有：uid，修改时间，标题模糊查询，标签，类型，发布状态（已发布，待发布，已完成）
     *          （待发布的条件是当前系统时间小于发布时间且状态为已完成）
     *      3、草稿箱查询条件有：修改时间，标题模糊搜索，类型，标签，发布状态默认未完成
     *
     *      一、只记录三十天浏览记录，分页加载
     *      二、历史记录搜索：
     *          1、作者姓名模糊搜索
     *          2、标题模糊搜索
     *          3、类型
     *          4、浏览时间查询
     *
     *      type：0-学习，1-生活，2-兴趣，3-提问
     *      status：0-未发布，1-已下线，2-待审批，3-未完成，4-删除，5-已发布, 6-待发布
     */


    /**
     *      返回数据时labelId存放姓名
     * @param page
     * @return
     * @throws Exception
     */
	@ApiOperation(value = "|ArticleEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:article:page")
    public ResponseMessage<PageInfo<ArticleEO>> page(ArticleEOPage page) throws Exception {
	    if (page.getType() != null && page.getType().equals("*")) {
	        page.setType(null);
        }
        List<ArticleEO> rows = articleEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), addAuthorName(rows)));
    }

    @ApiOperation(value = "|ArticleEO|好友文章")
    @GetMapping("/friPage")
    @RequiresPermissions("article:article:page")
    public ResponseMessage<PageInfo<ArticleEO>> getFriItem(ArticleEOPage page) throws Exception {
        List<ArticleEO> rows = articleEOService.getFriItems(page);

        return Result.success(getPageInfo(page.getPager(), addAuthorName(rows)));
    }

    private List<ArticleEO> addAuthorName(List<ArticleEO> rows) {
        List<ArticleEO> list = new ArrayList<ArticleEO>();
        for(ArticleEO eo : rows) {
            PersonInfoEO person = personInfoEOService.getPersonByUid(eo.getUId());
            eo.setLabelId(person.getName());
            list.add(eo);
        }
        return list;
    }

    @ApiOperation(value = "|ArticleEO|历史记录")
    @GetMapping("/historyList")
    @RequiresPermissions("article:article:page")
    public ResponseMessage<List<HistoryVo>> historyList(HistoryVo historyVo) throws Exception {

        return Result.success(articleEOService.queryHisList(historyVo));
    }

    /**
     * 加载文章内容
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ArticleEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("article:article:get")
    public ResponseMessage<ArticleEO> find(@PathVariable String id) throws Exception {
        return Result.success(articleEOService.selectByPrimaryKey(id));
    }

    /**
     *      类型，标签，发布时间，状态：保存-已完成、存草稿箱-未完成，发布-获取发布时间
     *      标题，正文,uid
     * @param articleEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ArticleEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("article:article:save")
    public ResponseMessage create(@RequestBody ArticleEO articleEO) throws Exception {
        Date now = new Date();
        articleEO.setCreateTime(now);
        articleEO.setUpdateTime(now);
        if (articleEO.getReleaseTime() != null && articleEO.getReleaseTime().getTime() > now.getTime()) {
            articleEO.setStatus(6);
        }
        if (articleEO.getId() != null) {
            articleEO.setId(UUID.randomUUID());
            articleEOService.insertSelective(articleEO);
            labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
        }
        articleEO.setId(UUID.randomUUID());

        /* 内容检查功能 */
        String checkContent = lexiconEOService.checkContent(articleEO.getContent(), 0);
        String level = checkContent.substring(0,5);
        if (level.equals("$del$")) {
            return Result.error("0", "", checkContent.substring(5,checkContent.length()));
        } else if (level.equals("$aut$")) {
            //移送管理员审核
            articleEO.setStatus(2);
            articleEOService.insertSelective(articleEO);
            labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
            return Result.error("1",null);
        } else if (level.equals("$che$")) {
            return Result.error("2", "", checkContent.substring(5,checkContent.length()));
        }

        articleEOService.insertSelective(articleEO);
        labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
        return Result.success(articleEO);
    }

    /**
     *      文章修改，状态修改,删除
     * @param articleEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ArticleEO|修改")
    @PostMapping("/update")
    @RequiresPermissions("article:article:update")
    public ResponseMessage<ArticleEO> update(@RequestBody ArticleEO articleEO) throws Exception {
        Date now = new Date();
        articleEO.setUpdateTime(now);
        if (articleEO.getReleaseTime() != null && articleEO.getReleaseTime().getTime() > now.getTime()) {
            articleEO.setStatus(6);
        }

        /* 内容检查 */
        String checkContent = lexiconEOService.checkContent(articleEO.getContent(), 0);
        String level = checkContent.substring(0,5);
        if (level.equals("$del$")) {
            return Result.error("0", checkContent.substring(5,checkContent.length()));
        } else if (level.equals("$aut$")) {
            //移送管理员审核
            articleEO.setStatus(2);
            articleEOService.updateByPrimaryKeySelective(articleEO);
            labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
            return Result.success("1",null);
        } else if (level.equals("$che$")) {
            return Result.error("2", checkContent.substring(5,checkContent.length()));
        }

        articleEOService.updateByPrimaryKeySelective(articleEO);
        labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
        return Result.success(articleEO);
    }

    @ApiOperation(value = "|Img|上传")
    @PostMapping("/imgUpLoad")
    @ResponseBody
    public ResponseMessage articleImgUpLoad(MultipartFile articleImg) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowPath = format.format(new Date());
        if (articleImg != null && !articleImg.isEmpty()) {
            File imgPath = saveImg(articleImg, FileUpLoad.getPathRoot() + "/articleImg/" + nowPath);
            if (imgPath == null) {
                return Result.error("图片上传失败");
            } else {
                ImgPathEO eo = new ImgPathEO();
                eo.setId(UUID.randomUUID());
                eo.setImgName(imgPath.getName());
                eo.setSuffix(FileUpLoad.getSuffixName(imgPath.getName()));
                eo.setPath(imgPath.getPath());
                imgPathEOService.insertSelective(eo);
                return Result.success(eo.getId());
            }
        }
        return Result.error("上传图片不存在");
    }

    @ApiOperation(value = "|ImgPath|图片显示")
    @GetMapping("/{id}/down")
    @RequiresPermissions("ImgPath:ImgPath:get")
    public void photoPath(@PathVariable String id, HttpServletResponse response) throws Exception {

        ImgPathEO eo = imgPathEOService.selectByPrimaryKey(id);
        if (eo != null) {
            File file = new File(eo.getPath());

            if (file.exists()) {
                try {
                    FileDownLoad.fileResponseDown(response, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private File saveImg(MultipartFile mft, String path) throws Exception {
        File file = new File(path + "/" + System.currentTimeMillis() + "." + FileUpLoad.getSuffixName(mft.getOriginalFilename()));
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (FileUpLoad.MulFileToFile(mft, file).equals("ok")) {
            return file;
        } else {
            return null;
        }
    }


}
