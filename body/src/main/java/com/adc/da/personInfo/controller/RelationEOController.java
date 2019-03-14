package com.adc.da.personInfo.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.NoticeEO;
import com.adc.da.personInfo.entity.RelationEO;
import com.adc.da.personInfo.service.NoticeEOService;
import com.adc.da.personInfo.service.RelationEOService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/${restPath}/personInfo/relation")
@Api(description = "|RelationEO|")
public class RelationEOController extends BaseController<RelationEO> {

    private static final Logger logger = LoggerFactory.getLogger(RelationEOController.class);

    @Autowired
    private RelationEOService relationEOService;

    @Autowired
    private NoticeEOService noticeEOService;

    /**
     * #   1、添加好友              -----新增数据       type：0 - status：0-已申请，1-已同意，2-已拒绝，3-已删除
     * #   2、同意/拒绝好友请求     -----修改
     * #   3、删除好友              -----物理删除
     * #   4、关注                  -----新增数据       type：3 - status：0-已关注，1-已取消, 2-已删除
     * #   5、取消关注              -----物理删除
     * #   6、好友查重（查询是否为好友）
     * #   7、关注查重（查询是否关注）
     */

    /**
     * 添加好友申请和关注
     * uid1，uid2, type
     *
     * @param relationEO
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @ApiOperation(value = "|RelationEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("personInfo:relation:save")
    public ResponseMessage create(@RequestBody RelationEO relationEO) throws Exception {

        relationEO.setId(UUID.randomUUID());
        relationEO.setCreateTime(new Date());
        relationEO.setStatus(0);
        if (relationEO.getType() == 0) {
            if (relationEOService.repeatFriend(relationEO) && relationEOService.insertSelective(relationEO) == 1) {
                //创建通知对象
                NoticeEO noticeEO = new NoticeEO();
                noticeEO.setUId1(relationEO.getUId1());
                noticeEO.setUId2(relationEO.getUId2());
                noticeEO.setType(0);
                noticeEO.setStatus(0);
                noticeEOService.insertSelective(noticeEO);
                return Result.success("邀请已发送！");
            }
        } else {
            if (relationEOService.repeatAtten(relationEO) && relationEOService.insertSelective(relationEO) == 1) {
                NoticeEO noticeEO = new NoticeEO();
                noticeEO.setUId1(relationEO.getUId1());
                noticeEO.setUId2(relationEO.getUId2());
                noticeEO.setType(3);
                noticeEO.setStatus(0);
                noticeEOService.insertSelective(noticeEO);
                return Result.success("已关注");
            }
        }
        return Result.error("发送失败！");
    }

    /**
     * 通过、拒绝、取消关注
     * uid1，uid2, type, status
     *
     * @param relationEO
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @ApiOperation(value = "|RelationEO|修改")
    @PostMapping("/update")
    @RequiresPermissions("personInfo:relation:update")
    public ResponseMessage<RelationEO> update(@RequestBody RelationEO relationEO) throws Exception {
        NoticeEO noticeEO = new NoticeEO();
        noticeEO.setStatus(relationEO.getStatus());
        noticeEO.setType(relationEO.getType());
        noticeEO.setUId1(relationEO.getUId1());
        noticeEO.setUId2(relationEO.getUId2());
        relationEO.setCreateTime(new Date());
        if (relationEOService.updateRelation(relationEO)) {
            noticeEOService.insertSelect(noticeEO);
            return Result.success(relationEO);
        } else {
            return Result.error();
        }

    }

}
