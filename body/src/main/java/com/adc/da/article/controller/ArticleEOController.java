package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.article.entity.vo.HistoryVo;
import com.adc.da.article.service.LabelEOService;
import com.adc.da.util.utils.UUID;
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

@RestController
@RequestMapping("/${restPath}/article/article")
@Api(description = "|ArticleEO|")
public class ArticleEOController extends BaseController<ArticleEO>{

    private static final Logger logger = LoggerFactory.getLogger(ArticleEOController.class);

    @Autowired
    private ArticleEOService articleEOService;

    @Autowired
    private LabelEOService labelEOService;

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
     *      status：0-已完成，1-已下线，2-待审批，3-未完成，4-删除
     */

	@ApiOperation(value = "|ArticleEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:article:page")
    public ResponseMessage<PageInfo<ArticleEO>> page(ArticleEOPage page) throws Exception {
        List<ArticleEO> rows = articleEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
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
     *      类型，标签，发布时间，状态：保存-已完成、存草稿箱-未完成，发布-获取发布时间，若为空则立即发布
     *      标题，正文,uid
     * @param articleEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ArticleEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:article:save")
    public ResponseMessage<ArticleEO> create(@RequestBody ArticleEO articleEO) throws Exception {
        articleEO.setId(UUID.randomUUID());
        Date now = new Date();
        articleEO.setCreateTime(now);
        articleEO.setUpdateTime(now);

        /* 内容检查功能 */

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
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:article:update")
    public ResponseMessage<ArticleEO> update(@RequestBody ArticleEO articleEO) throws Exception {
        articleEO.setUpdateTime(new Date());

        /* 内容检查 */

        articleEOService.updateByPrimaryKeySelective(articleEO);
        labelEOService.setLabelNum(articleEO.getUId(), articleEO.getLabelId());
        return Result.success(articleEO);
    }

}
