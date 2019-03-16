package com.adc.da.admin.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.admin.entity.AfficheEO;
import com.adc.da.admin.page.AfficheEOPage;
import com.adc.da.admin.service.AfficheEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/admin/affiche")
@Api(description = "|AfficheEO|")
public class AfficheEOController extends BaseController<AfficheEO>{

    private static final Logger logger = LoggerFactory.getLogger(AfficheEOController.class);

    /**
     *      type: 0-管理员发布的公告，1-用户申请的公告，2-管理员公告上线，3-用户公告上线
     *              4-用户公告驳回
     */

    @Autowired
    private AfficheEOService afficheEOService;

	@ApiOperation(value = "|AfficheEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("admin:affiche:page")
    public ResponseMessage<PageInfo<AfficheEO>> page(AfficheEOPage page) throws Exception {
        List<AfficheEO> rows = afficheEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|AfficheEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("admin:affiche:get")
    public ResponseMessage<AfficheEO> find(@PathVariable String id) throws Exception {
        return Result.success(afficheEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|AfficheEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("admin:affiche:save")
    public ResponseMessage<AfficheEO> create(@RequestBody AfficheEO afficheEO) throws Exception {
        afficheEO.setId(UUID.randomUUID());
        afficheEO.setCreateTime(new Date());
        afficheEOService.insertSelective(afficheEO);
        return Result.success(afficheEO);
    }

    @ApiOperation(value = "|AfficheEO|修改")
    @PostMapping("/update")
    @RequiresPermissions("admin:affiche:update")
    public ResponseMessage<AfficheEO> update(@RequestBody AfficheEO afficheEO) throws Exception {
        afficheEOService.updateByPrimaryKeySelective(afficheEO);
        return Result.success(afficheEO);
    }

    @ApiOperation(value = "|AfficheEO|删除")
    @GetMapping("/delete/{id}")
    @RequiresPermissions("admin:affiche:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        afficheEOService.deleteByPrimaryKey(id);
        return Result.success();
    }

}
