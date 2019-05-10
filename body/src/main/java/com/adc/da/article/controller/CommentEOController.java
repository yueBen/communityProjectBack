package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.admin.service.LexiconEOService;
import com.adc.da.personInfo.entity.NoticeEO;
import com.adc.da.personInfo.service.NoticeEOService;
import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.article.entity.CommentEO;
import com.adc.da.article.page.CommentEOPage;
import com.adc.da.article.service.CommentEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/article/comment")
@Api(description = "|CommentEO|")
public class CommentEOController extends BaseController<CommentEO> {

    private static final Logger logger = LoggerFactory.getLogger(CommentEOController.class);

    @Autowired
    private CommentEOService commentEOService;

    @Autowired
    private NoticeEOService noticeEOService;

    @Autowired
    private LexiconEOService lexiconEOService;

    /**
     *      uid - 评论创建人的id
     *      on_id - 被评论人的id
     *      pid - 评论的父级id
     *      type：0-文章子评论、1-评论子评论、2-留言子评论
     *
     *      status: 0-未读，1-已读， 2-删除
     */


    /**
     *
     *  通过pid查询评论，时间倒序排列
     *
     * @param page
     * @return
     * @author yueben
     * 2019-03-15
     **/
    @ApiOperation(value = "|CommentEO|查询")
    @GetMapping("/list")
    @RequiresPermissions("article:comment:list")
    public ResponseMessage<List<CommentEO>> list(CommentEOPage page) throws Exception {
        return Result.success(commentEOService.queryByList(page));
    }

    @ApiOperation(value = "|CommentEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("article:comment:get")
    public ResponseMessage<CommentEO> find(@PathVariable String id) throws Exception {
        return Result.success(commentEOService.selectByPrimaryKey(id));
    }

    /**
     *
     *      新增传入：uid，onid，pid，type，content
     *
     * @param commentEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|CommentEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("article:comment:save")
    public ResponseMessage create(@RequestBody CommentEO commentEO) throws Exception {
        commentEO.setId(UUID.randomUUID());
        commentEO.setCreateTime(new Date());
        commentEO.setStatus(0);

        /* 评论内容过滤返回 */
        String checkContent = lexiconEOService.checkContent(commentEO.getContent(), 1);
        if (checkContent == null) {
            return Result.error("0");
        } else {
            commentEO.setContent(checkContent);
        }

        if (commentEOService.insertSelective(commentEO) == 1) {
            //父评论计数
            commentEOService.setCommCount(commentEO.getPId(), 1);
            //生成通知
            NoticeEO noticeEO = new NoticeEO();
            noticeEO.setUId1(commentEO.getUId());
            noticeEO.setUId2(commentEO.getOnId());
            noticeEO.setToId(commentEO.getId());
            noticeEO.setType(1);
            noticeEO.setStatus(commentEO.getType() != 2 ? commentEO.getType() : null);
            noticeEOService.insertSelect(noticeEO);
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /**
    *  操作评论的 赞、踩、删除
     *      传入id，status（用作判断操作）：0-新赞，1-新踩，2-取消赞，3-取消踩，4-赞转踩，5-踩转赞，6-删除，
     *      onid（操作人id，若不是评论人则不能删除）,uid（当前评论的用户ID）
     * @param commentEO
    * @return
    * @author yueben
    * 2019-03-15
    **/
    @ApiOperation(value = "|CommentEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:comment:update")
    public ResponseMessage<CommentEO> update(@RequestBody CommentEO commentEO) throws Exception {
        Integer status = commentEO.getStatus();
        commentEO.setStatus(null);
        switch (status) {
            case 0:
                //新获得的赞
                commentEO.setLikeNum(1);
                if (commentEOService.updateByPrimaryKeySelective(commentEO) == 1) {
                    NoticeEO noticeEO = new NoticeEO(commentEO.getOnId(), commentEO.getUId(), commentEO.getId(),1,2,null);
                    noticeEOService.insertSelect(noticeEO);
                }
                break;
            case 1:
                //新获得的踩
                commentEO.setDislikeNum(1);
                if (commentEOService.updateByPrimaryKeySelective(commentEO) == 1) {
                    NoticeEO noticeEO = new NoticeEO(commentEO.getOnId(), commentEO.getUId(), commentEO.getId(),1,3, null);
                    noticeEOService.insertSelect(noticeEO);
                }
                break;
            case 2:
                //取消的赞
                commentEO.setLikeNum(-1);
                commentEOService.updateByPrimaryKeySelective(commentEO);
                break;
            case 3:
                //取消的踩
                commentEO.setDislikeNum(-1);
                commentEOService.updateByPrimaryKeySelective(commentEO);
                break;
            case 4:
                //赞转踩
                commentEO.setLikeNum(-1);
                commentEO.setDislikeNum(1);
                commentEOService.updateByPrimaryKeySelective(commentEO);
                break;
            case 5:
                //踩转赞
                commentEO.setLikeNum(1);
                commentEO.setDislikeNum(-1);
                commentEOService.updateByPrimaryKeySelective(commentEO);
                break;
            case 6:
                //删除
                commentEO.setStatus(2);
                commentEOService.updateByPrimaryKeySelective(commentEO);
                break;
        }
        return Result.success(commentEO);
    }

}
