package com.adc.da.article.controller;

import com.adc.da.article.entity.LabelEO;
import com.adc.da.article.page.LabelEOPage;
import com.adc.da.article.service.LabelEOService;
import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/${restPath}/article/label")
@Api(description = "|LabelEO|")
public class LabelEOController extends BaseController<LabelEO>{

    private static final Logger logger = LoggerFactory.getLogger(LabelEOController.class);

    @Autowired
    private LabelEOService labelEOService;


	@ApiOperation(value = "|LabelEO|查询")
    @GetMapping("/list")
    @RequiresPermissions("article:label:list")
    public ResponseMessage<List<LabelEO>> list(LabelEOPage page) throws Exception {
        return Result.success(labelEOService.queryByList(page));
	}

    @ApiOperation(value = "|LabelEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("article:label:save")
    public ResponseMessage<List<LabelEO>> create(@RequestBody LabelEO labelEO) throws Exception {
	    labelEO.setId(UUID.randomUUID());
	    labelEO.setNum(0);
	    if (labelEOService.isLabelNameRepeat(labelEO.getLabelName())) {
            labelEOService.insertSelective(labelEO);
            LabelEOPage page = new LabelEOPage();
            page.setUId(labelEO.getUId());
            return Result.success(labelEOService.queryByList(page));
        } else {
	        return Result.error("标签重复");
        }


    }

    @ApiOperation(value = "|LabelEO|删除")
    @GetMapping("/{id}")
    @RequiresPermissions("article:label:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {

        LabelEO labelEO = labelEOService.selectByPrimaryKey(id);
        if (labelEO.getNum() > 0) {
            return Result.error();
        } else {
            labelEOService.deleteByPrimaryKey(id);
            return Result.success();
        }
    }
}
