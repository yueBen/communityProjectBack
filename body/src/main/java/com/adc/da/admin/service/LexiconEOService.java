package com.adc.da.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.admin.dao.LexiconEODao;
import com.adc.da.admin.entity.LexiconEO;


/**
 *
 * <br>
 * <b>功能：</b>lexicon LexiconEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("lexiconEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class LexiconEOService extends BaseService<LexiconEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(LexiconEOService.class);

    @Autowired
    private LexiconEODao dao;

    public LexiconEODao getDao() {
        return dao;
    }

}
