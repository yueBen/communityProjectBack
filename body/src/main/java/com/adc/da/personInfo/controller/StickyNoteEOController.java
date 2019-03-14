package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.personInfo.entity.NoticeEO;
import com.adc.da.util.utils.UUID;
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

    /**
     *      status：0-未读，1-已读，2-删除
     *      uid1-留言人id
     *      uid2-我的id
     */


	@ApiOperation(value = "|StickyNoteEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:stickyNote:page")
    public ResponseMessage<PageInfo<StickyNoteEO>> page(StickyNoteEOPage page) throws Exception {
        List<StickyNoteEO> rows = stickyNoteEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|StickyNoteEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:stickyNote:save")
    public ResponseMessage create(@RequestBody StickyNoteEO stickyNoteEO) throws Exception {
        stickyNoteEO.setId(UUID.randomUUID());
        stickyNoteEO.setCreateTime(new Date());
        stickyNoteEO.setStatus(0);

        if (stickyNoteEOService.insertSelective(stickyNoteEO) == 1){
            NoticeEO noticeEO = new NoticeEO();
            noticeEO.setType(4);
            noticeEO.setStatus(0);
            noticeEO.setUId1(stickyNoteEO.getUId1());
            noticeEO.setUId2(stickyNoteEO.getUId2());
            noticeEO.setToId(stickyNoteEO.getId());
            return Result.success();
        }
        return Result.error();
    }

    @ApiOperation(value = "|StickyNoteEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:stickyNote:update")
    public ResponseMessage<StickyNoteEO> update(@RequestBody StickyNoteEO stickyNoteEO) throws Exception {
        stickyNoteEOService.updateByPrimaryKeySelective(stickyNoteEO);
        return Result.success(stickyNoteEO);
    }


}
