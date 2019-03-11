package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

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
public class CommentEOController extends BaseController<CommentEO>{

    private static final Logger logger = LoggerFactory.getLogger(CommentEOController.class);

    @Autowired
    private CommentEOService commentEOService;

	@ApiOperation(value = "|CommentEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:comment:page")
    public ResponseMessage<PageInfo<CommentEO>> page(CommentEOPage page) throws Exception {
        List<CommentEO> rows = commentEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|CommentEO|查询")
    @GetMapping("")
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

    @ApiOperation(value = "|CommentEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:comment:save")
    public ResponseMessage<CommentEO> create(@RequestBody CommentEO commentEO) throws Exception {
        commentEOService.insertSelective(commentEO);
        return Result.success(commentEO);
    }

    @ApiOperation(value = "|CommentEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:comment:update")
    public ResponseMessage<CommentEO> update(@RequestBody CommentEO commentEO) throws Exception {
        commentEOService.updateByPrimaryKeySelective(commentEO);
        return Result.success(commentEO);
    }

    @ApiOperation(value = "|CommentEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("article:comment:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        commentEOService.deleteByPrimaryKey(id);
        logger.info("delete from comment where id = {}", id);
        return Result.success();
    }

}
