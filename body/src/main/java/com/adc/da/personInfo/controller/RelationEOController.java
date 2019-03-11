package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.RelationEO;
import com.adc.da.personInfo.page.RelationEOPage;
import com.adc.da.personInfo.service.RelationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/personInfo/relation")
@Api(description = "|RelationEO|")
public class RelationEOController extends BaseController<RelationEO>{

    private static final Logger logger = LoggerFactory.getLogger(RelationEOController.class);

    @Autowired
    private RelationEOService relationEOService;

	@ApiOperation(value = "|RelationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:relation:page")
    public ResponseMessage<PageInfo<RelationEO>> page(RelationEOPage page) throws Exception {
        List<RelationEO> rows = relationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|RelationEO|查询")
    @GetMapping("")
    @RequiresPermissions("personInfo:relation:list")
    public ResponseMessage<List<RelationEO>> list(RelationEOPage page) throws Exception {
        return Result.success(relationEOService.queryByList(page));
	}

    @ApiOperation(value = "|RelationEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("personInfo:relation:get")
    public ResponseMessage<RelationEO> find(@PathVariable String id) throws Exception {
        return Result.success(relationEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|RelationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:relation:save")
    public ResponseMessage<RelationEO> create(@RequestBody RelationEO relationEO) throws Exception {
        relationEOService.insertSelective(relationEO);
        return Result.success(relationEO);
    }

    @ApiOperation(value = "|RelationEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:relation:update")
    public ResponseMessage<RelationEO> update(@RequestBody RelationEO relationEO) throws Exception {
        relationEOService.updateByPrimaryKeySelective(relationEO);
        return Result.success(relationEO);
    }

    @ApiOperation(value = "|RelationEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("personInfo:relation:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        relationEOService.deleteByPrimaryKey(id);
        logger.info("delete from relation where id = {}", id);
        return Result.success();
    }

}
