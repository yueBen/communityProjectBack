package com.adc.da.admin.controller;

import com.adc.da.admin.entity.LexiconEO;
import com.adc.da.admin.page.LexiconEOPage;
import com.adc.da.admin.service.LexiconEOService;
import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

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
        page.setPageSize(1000);
        List<LexiconEO> rows = lexiconEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|LexiconEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("admin:lexicon:save")
    public ResponseMessage<LexiconEO> create(@RequestBody LexiconEO lexiconEO) throws Exception {
	    lexiconEO.setId(UUID.randomUUID());
        lexiconEOService.insertSelective(lexiconEO);
        return Result.success(lexiconEO);
    }

    @ApiOperation(value = "|LexiconEO|修改")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("admin:lexicon:update")
    public ResponseMessage<LexiconEO> update(@RequestBody LexiconEO lexiconEO) throws Exception {
        lexiconEOService.updateByPrimaryKeySelective(lexiconEO);
        return Result.success(lexiconEO);
    }

    @ApiOperation(value = "|LexiconEO|删除")
    @GetMapping("/{id}")
    @RequiresPermissions("admin:lexicon:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        lexiconEOService.deleteByPrimaryKey(id);
        return Result.success();
    }

}
