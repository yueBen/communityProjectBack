package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.article.entity.HistoryEO;
import com.adc.da.article.page.HistoryEOPage;
import com.adc.da.article.service.HistoryEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/article/history")
@Api(description = "|HistoryEO|")
public class HistoryEOController extends BaseController<HistoryEO>{

    private static final Logger logger = LoggerFactory.getLogger(HistoryEOController.class);

    @Autowired
    private HistoryEOService historyEOService;

	@ApiOperation(value = "|HistoryEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:history:page")
    public ResponseMessage<PageInfo<HistoryEO>> page(HistoryEOPage page) throws Exception {
        List<HistoryEO> rows = historyEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|HistoryEO|查询")
    @GetMapping("")
    @RequiresPermissions("article:history:list")
    public ResponseMessage<List<HistoryEO>> list(HistoryEOPage page) throws Exception {
        return Result.success(historyEOService.queryByList(page));
	}

    @ApiOperation(value = "|HistoryEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("article:history:get")
    public ResponseMessage<HistoryEO> find(@PathVariable String id) throws Exception {
        return Result.success(historyEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|HistoryEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:history:save")
    public ResponseMessage<HistoryEO> create(@RequestBody HistoryEO historyEO) throws Exception {
        historyEOService.insertSelective(historyEO);
        return Result.success(historyEO);
    }

    @ApiOperation(value = "|HistoryEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:history:update")
    public ResponseMessage<HistoryEO> update(@RequestBody HistoryEO historyEO) throws Exception {
        historyEOService.updateByPrimaryKeySelective(historyEO);
        return Result.success(historyEO);
    }

    @ApiOperation(value = "|HistoryEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("article:history:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        historyEOService.deleteByPrimaryKey(id);
        logger.info("delete from history where id = {}", id);
        return Result.success();
    }

}
