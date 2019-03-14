package com.adc.da.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.admin.dao.AfficheEODao;
import com.adc.da.admin.entity.AfficheEO;


/**
 *
 * <br>
 * <b>功能：</b>affiche AfficheEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("afficheEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class AfficheEOService extends BaseService<AfficheEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(AfficheEOService.class);

    @Autowired
    private AfficheEODao dao;

    public AfficheEODao getDao() {
        return dao;
    }

}