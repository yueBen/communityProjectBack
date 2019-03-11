package com.adc.da.article.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.article.entity.ArticleEO;
import com.adc.da.article.page.ArticleEOPage;
import com.adc.da.article.service.ArticleEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/article/article")
@Api(description = "|ArticleEO|")
public class ArticleEOController extends BaseController<ArticleEO>{

    private static final Logger logger = LoggerFactory.getLogger(ArticleEOController.class);

    @Autowired
    private ArticleEOService articleEOService;

	@ApiOperation(value = "|ArticleEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("article:article:page")
    public ResponseMessage<PageInfo<ArticleEO>> page(ArticleEOPage page) throws Exception {
        List<ArticleEO> rows = articleEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|ArticleEO|查询")
    @GetMapping("")
    @RequiresPermissions("article:article:list")
    public ResponseMessage<List<ArticleEO>> list(ArticleEOPage page) throws Exception {
        return Result.success(articleEOService.queryByList(page));
	}

    @ApiOperation(value = "|ArticleEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("article:article:get")
    public ResponseMessage<ArticleEO> find(@PathVariable String id) throws Exception {
        return Result.success(articleEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|ArticleEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:article:save")
    public ResponseMessage<ArticleEO> create(@RequestBody ArticleEO articleEO) throws Exception {
        articleEOService.insertSelective(articleEO);
        return Result.success(articleEO);
    }

    @ApiOperation(value = "|ArticleEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("article:article:update")
    public ResponseMessage<ArticleEO> update(@RequestBody ArticleEO articleEO) throws Exception {
        articleEOService.updateByPrimaryKeySelective(articleEO);
        return Result.success(articleEO);
    }

    @ApiOperation(value = "|ArticleEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("article:article:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        articleEOService.deleteByPrimaryKey(id);
        logger.info("delete from article where id = {}", id);
        return Result.success();
    }

}
