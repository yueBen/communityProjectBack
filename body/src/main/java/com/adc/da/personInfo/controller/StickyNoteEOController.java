package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.StickyNoteEO;
import com.adc.da.personInfo.page.StickyNoteEOPage;
import com.adc.da.personInfo.service.StickyNoteEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/personInfo/stickyNote")
@Api(description = "|StickyNoteEO|")
public class StickyNoteEOController extends BaseController<StickyNoteEO>{

    private static final Logger logger = LoggerFactory.getLogger(StickyNoteEOController.class);

    @Autowired
    private StickyNoteEOService stickyNoteEOService;

	@ApiOperation(value = "|StickyNoteEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:stickyNote:page")
    public ResponseMessage<PageInfo<StickyNoteEO>> page(StickyNoteEOPage page) throws Exception {
        List<StickyNoteEO> rows = stickyNoteEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|StickyNoteEO|查询")
    @GetMapping("")
    @RequiresPermissions("personInfo:stickyNote:list")
    public ResponseMessage<List<StickyNoteEO>> list(StickyNoteEOPage page) throws Exception {
        return Result.success(stickyNoteEOService.queryByList(page));
	}

    @ApiOperation(value = "|StickyNoteEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("personInfo:stickyNote:get")
    public ResponseMessage<StickyNoteEO> find(@PathVariable String id) throws Exception {
        return Result.success(stickyNoteEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|StickyNoteEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:stickyNote:save")
    public ResponseMessage<StickyNoteEO> create(@RequestBody StickyNoteEO stickyNoteEO) throws Exception {
        stickyNoteEOService.insertSelective(stickyNoteEO);
        return Result.success(stickyNoteEO);
    }

    @ApiOperation(value = "|StickyNoteEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:stickyNote:update")
    public ResponseMessage<StickyNoteEO> update(@RequestBody StickyNoteEO stickyNoteEO) throws Exception {
        stickyNoteEOService.updateByPrimaryKeySelective(stickyNoteEO);
        return Result.success(stickyNoteEO);
    }

    @ApiOperation(value = "|StickyNoteEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("personInfo:stickyNote:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        stickyNoteEOService.deleteByPrimaryKey(id);
        logger.info("delete from sticky_note where id = {}", id);
        return Result.success();
    }

}
