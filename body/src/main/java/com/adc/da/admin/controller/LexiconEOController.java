package com.adc.da.admin.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.admin.entity.LexiconEO;
import com.adc.da.admin.page.LexiconEOPage;
import com.adc.da.admin.service.LexiconEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/admin/lexicon")
@Api(description = "|LexiconEO|")
public class LexiconEOController extends BaseController<LexiconEO>{

    private static final Logger logger = LoggerFactory.getLogger(LexiconEOController.class);

    @Autowired
    private LexiconEOService lexiconEOService;

	@ApiOperation(value = "|LexiconEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("admin:lexicon:page")
    public ResponseMessage<PageInfo<LexiconEO>> page(LexiconEOPage page) throws Exception {
        List<LexiconEO> rows = lexiconEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|LexiconEO|查询")
    @GetMapping("")
    @RequiresPermissions("admin:lexicon:list")
    public ResponseMessage<List<LexiconEO>> list(LexiconEOPage page) throws Exception {
        return Result.success(lexiconEOService.queryByList(page));
	}

    @ApiOperation(value = "|LexiconEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("admin:lexicon:get")
    public ResponseMessage<LexiconEO> find(@PathVariable String id) throws Exception {
        return Result.success(lexiconEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|LexiconEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("admin:lexicon:save")
    public ResponseMessage<LexiconEO> create(@RequestBody LexiconEO lexiconEO) throws Exception {
        lexiconEOService.insertSelective(lexiconEO);
        return Result.success(lexiconEO);
    }

    @ApiOperation(value = "|LexiconEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("admin:lexicon:update")
    public ResponseMessage<LexiconEO> update(@RequestBody LexiconEO lexiconEO) throws Exception {
        lexiconEOService.updateByPrimaryKeySelective(lexiconEO);
        return Result.success(lexiconEO);
    }

    @ApiOperation(value = "|LexiconEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("admin:lexicon:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        lexiconEOService.deleteByPrimaryKey(id);
        logger.info("delete from lexicon where id = {}", id);
        return Result.success();
    }

}
