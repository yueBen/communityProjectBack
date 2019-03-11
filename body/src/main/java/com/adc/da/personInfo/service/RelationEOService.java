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


/**
 *
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

}
