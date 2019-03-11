package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.PersonInfoEO;
import com.adc.da.personInfo.page.PersonInfoEOPage;
import com.adc.da.personInfo.service.PersonInfoEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/personInfo/personInfo")
@Api(description = "|PersonInfoEO|")
public class PersonInfoEOController extends BaseController<PersonInfoEO>{

    private static final Logger logger = LoggerFactory.getLogger(PersonInfoEOController.class);

    @Autowired
    private PersonInfoEOService personInfoEOService;

	@ApiOperation(value = "|PersonInfoEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("personInfo:personInfo:page")
    public ResponseMessage<PageInfo<PersonInfoEO>> page(PersonInfoEOPage page) throws Exception {
        List<PersonInfoEO> rows = personInfoEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|PersonInfoEO|查询")
    @GetMapping("")
    @RequiresPermissions("personInfo:personInfo:list")
    public ResponseMessage<List<PersonInfoEO>> list(PersonInfoEOPage page) throws Exception {
        return Result.success(personInfoEOService.queryByList(page));
	}

    @ApiOperation(value = "|PersonInfoEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("personInfo:personInfo:get")
    public ResponseMessage<PersonInfoEO> find(@PathVariable String id) throws Exception {
        return Result.success(personInfoEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|PersonInfoEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:personInfo:save")
    public ResponseMessage<PersonInfoEO> create(@RequestBody PersonInfoEO personInfoEO) throws Exception {
        personInfoEOService.insertSelective(personInfoEO);
        return Result.success(personInfoEO);
    }

    @ApiOperation(value = "|PersonInfoEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:personInfo:update")
    public ResponseMessage<PersonInfoEO> update(@RequestBody PersonInfoEO personInfoEO) throws Exception {
        personInfoEOService.updateByPrimaryKeySelective(personInfoEO);
        return Result.success(personInfoEO);
    }

    @ApiOperation(value = "|PersonInfoEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("personInfo:personInfo:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        personInfoEOService.deleteByPrimaryKey(id);
        logger.info("delete from person_info where id = {}", id);
        return Result.success();
    }

}
