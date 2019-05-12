package com.adc.da.personInfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.personInfo.dao.RelationEODao;
import com.adc.da.personInfo.entity.RelationEO;

import java.util.List;


/**
 * <br>
 * <b>功能：</b>relation RelationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("relationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class RelationEOService extends BaseService<RelationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(RelationEOService.class);

    @Autowired
    private RelationEODao dao;

    public RelationEODao getDao() {
        return dao;
    }


    /**
     * 通过/拒绝好友请求，取消关注
     *
     * @param relationEO
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @Transactional
    public boolean updateRelation(RelationEO relationEO) {
        return dao.updateRelation(relationEO) == 1;
    }

    /**
     * 好友查重
     *
     * @param relationEO
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @Transactional
    public boolean repeatFriend(RelationEO relationEO) {
        int i = dao.repeatFriend(relationEO);
        return i == 0;
    }

    /**
     * 关注查重
     *
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @Transactional
    public boolean repeatAtten(RelationEO relationEO) {
        int i = dao.repeatAtten(relationEO);
        return i == 0;
    }

}
