package com.adc.da.article.controller;

import com.adc.da.article.entity.HistoryEO;
import com.adc.da.article.service.HistoryEOService;
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
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/${restPath}/article/history")
@Api(description = "|HistoryEO|")
public class HistoryEOController extends BaseController<HistoryEO>{

    private static final Logger logger = LoggerFactory.getLogger(HistoryEOController.class);

    @Autowired
    private HistoryEOService historyEOService;

    /**
     *      一、历史记录内容在article里面加载
     *      二、新增
     *      三、删除
     *
     */


    /**
     * 新增传参：
     *      1、uid
     *      2、aid
     *      3、用户头像
     *      4、文章图片

     * @param historyEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|HistoryEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("article:history:save")
    public ResponseMessage create(@RequestBody HistoryEO historyEO) throws Exception {
        historyEO.setBrowseTime(new Date());
        historyEO.setId(UUID.randomUUID());
        if (historyEOService.insertSelective(historyEO) == 1) {
            return Result.success("新增成功");
        }
        return Result.error("新增失败");
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
