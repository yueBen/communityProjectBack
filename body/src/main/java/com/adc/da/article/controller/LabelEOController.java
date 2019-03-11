package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.article.entity.LabelEO;
import com.adc.da.article.page.LabelEOPage;
import com.adc.da.article.service.LabelEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/article/label")
@Api(description = "|LabelEO|")
public class LabelEOController extends BaseController<LabelEO>{

    private static final Logger logger = LoggerFactory.getLogger(LabelEOController.class);

    @Autowired
    private LabelEOService labelEOService;

	@ApiOperation(value = "|LabelEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:label:page")
    public ResponseMessage<PageInfo<LabelEO>> page(LabelEOPage page) throws Exception {
        List<LabelEO> rows = labelEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|LabelEO|查询")
    @GetMapping("")
    @RequiresPermissions("article:label:list")
    public ResponseMessage<List<LabelEO>> list(LabelEOPage page) throws Exception {
        return Result.success(labelEOService.queryByList(page));
	}

    @ApiOperation(value = "|LabelEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("article:label:get")
    public ResponseMessage<LabelEO> find(@PathVariable String id) throws Exception {
        return Result.success(labelEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|LabelEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:label:save")
    public ResponseMessage<LabelEO> create(@RequestBody LabelEO labelEO) throws Exception {
        labelEOService.insertSelective(labelEO);
        return Result.success(labelEO);
    }

    @ApiOperation(value = "|LabelEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:label:update")
    public ResponseMessage<LabelEO> update(@RequestBody LabelEO labelEO) throws Exception {
        labelEOService.updateByPrimaryKeySelective(labelEO);
        return Result.success(labelEO);
    }

    @ApiOperation(value = "|LabelEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("article:label:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        labelEOService.deleteByPrimaryKey(id);
        logger.info("delete from label where id = {}", id);
        return Result.success();
    }

}
