package com.adc.da.textMySqlDB.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.textMySqlDB.entity.UserEO;
import com.adc.da.textMySqlDB.page.UserEOPage;
import com.adc.da.textMySqlDB.service.UserEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/textMySqlDB/user")
@Api(description = "|UserEO|")
public class UserEOController extends BaseController<UserEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserEOController.class);

    @Autowired
    private UserEOService userEOService;

	@ApiOperation(value = "|UserEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("textMySqlDB:user:page")
    public ResponseMessage<PageInfo<UserEO>> page(UserEOPage page) throws Exception {
        List<UserEO> rows = userEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|UserEO|查询")
    @GetMapping("")
    @RequiresPermissions("textMySqlDB:user:list")
    public ResponseMessage<List<UserEO>> list(UserEOPage page) throws Exception {
        return Result.success(userEOService.queryByList(page));
	}

    @ApiOperation(value = "|UserEO|详情")
    @GetMapping("/{uid}")
    @RequiresPermissions("textMySqlDB:user:get")
    public ResponseMessage<UserEO> find(@PathVariable String uid) throws Exception {
        return Result.success(userEOService.selectByPrimaryKey(uid));
    }

    @ApiOperation(value = "|UserEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("textMySqlDB:user:save")
    public ResponseMessage<UserEO> create(@RequestBody UserEO userEO) throws Exception {
        userEOService.insertSelective(userEO);
        return Result.success(userEO);
    }

    @ApiOperation(value = "|UserEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("textMySqlDB:user:update")
    public ResponseMessage<UserEO> update(@RequestBody UserEO userEO) throws Exception {
        userEOService.updateByPrimaryKeySelective(userEO);
        return Result.success(userEO);
    }

    @ApiOperation(value = "|UserEO|删除")
    @DeleteMapping("/{uid}")
    @RequiresPermissions("textMySqlDB:user:delete")
    public ResponseMessage delete(@PathVariable String uid) throws Exception {
        userEOService.deleteByPrimaryKey(uid);
        logger.info("delete from user where uid = {}", uid);
        return Result.success();
    }

}
