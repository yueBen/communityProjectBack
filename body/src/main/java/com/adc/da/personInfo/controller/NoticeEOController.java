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
public class NoticeEOController extends BaseController<NoticeEO>{

    private static final Logger logger = LoggerFactory.getLogger(NoticeEOController.class);

    @Autowired
    private NoticeEOService noticeEOService;

	@ApiOperation(value = "|NoticeEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:notice:page")
    public ResponseMessage<PageInfo<NoticeEO>> page(NoticeEOPage page) throws Exception {
        List<NoticeEO> rows = noticeEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|NoticeEO|查询")
    @GetMapping("")
    @RequiresPermissions("personInfo:notice:list")
    public ResponseMessage<List<NoticeEO>> list(NoticeEOPage page) throws Exception {
        return Result.success(noticeEOService.queryByList(page));
	}

    @ApiOperation(value = "|NoticeEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("personInfo:notice:get")
    public ResponseMessage<NoticeEO> find(@PathVariable String id) throws Exception {
        return Result.success(noticeEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|NoticeEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:notice:save")
    public ResponseMessage<NoticeEO> create(@RequestBody NoticeEO noticeEO) throws Exception {
        noticeEOService.insertSelective(noticeEO);
        return Result.success(noticeEO);
    }

    @ApiOperation(value = "|NoticeEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:notice:update")
    public ResponseMessage<NoticeEO> update(@RequestBody NoticeEO noticeEO) throws Exception {
        noticeEOService.updateByPrimaryKeySelective(noticeEO);
        return Result.success(noticeEO);
    }

    @ApiOperation(value = "|NoticeEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("personInfo:notice:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        noticeEOService.deleteByPrimaryKey(id);
        logger.info("delete from notice where id = {}", id);
        return Result.success();
    }

}
