package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.NoticeEO;
import com.adc.da.personInfo.page.NoticeEOPage;
import com.adc.da.personInfo.service.NoticeEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/personInfo/notice")
@Api(description = "|NoticeEO|")
public class NoticeEOController extends BaseController<NoticeEO> {

    private static final Logger logger = LoggerFactory.getLogger(NoticeEOController.class);

    @Autowired
    private NoticeEOService noticeEOService;

    /**
     *      type:
     *          0-用户
     *              status：0-申请，1-已同意，2-已拒绝，3-已删除
     *          1-评论
     *              status：0-文章新评论，1-评论新评论，2-赞，3-踩
     *          2-文章类通知
     *              status：0-收藏，1-赞，2-踩
     *          3-关注
     *              status：0-已关注，1-已取消
     *          4-留言
     *              status：0
     *      isRead：0-未读，1-已读，2-删除
     */

    /**
     * id存放用户uid
     * @Description: 分页条件查询
     * @Author: yueben
     * @CreateDate: 2019/3/13 20:01
     */
    @ApiOperation(value = "|NoticeEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:notice:page")
    public ResponseMessage<List<NoticeEO>> page(NoticeEOPage page) throws Exception {
        return Result.success(noticeEOService.queryPage(page));
    }

    @ApiOperation(value = "|NoticeEO|一键已读")
    @GetMapping("/readAll")
    @RequiresPermissions("personInfo:notice:update")
    public ResponseMessage readAll() {
        return Result.success(noticeEOService.readAll());
    }

    @ApiOperation(value = "|NoticeEO|删除已读")
    @GetMapping("/readDel")
    @RequiresPermissions("personInfo:notice:update")
    public ResponseMessage readDel() {
        return Result.success(noticeEOService.readDel());
    }

    @ApiOperation(value = "|NoticeEO|删除or已读")
    @GetMapping("/updateItem")
    @RequiresPermissions("personInfo:notice:update")
    public ResponseMessage delReadById(String id, String isRead) {
        if (noticeEOService.delReadById(id, isRead)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

}
