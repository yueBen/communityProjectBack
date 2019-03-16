package com.adc.da.article.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.article.dao.HistoryEODao;
import com.adc.da.article.entity.HistoryEO;


/**
 *
 * <br>
 * <b>功能：</b>history HistoryEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("historyEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class HistoryEOService extends BaseService<HistoryEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(HistoryEOService.class);

    @Autowired
    private HistoryEODao dao;

    public HistoryEODao getDao() {
        return dao;
    }

    @Transactional(readOnly = true)
    public boolean repeat(String uid, String aid) {
        return dao.repeat(uid, aid) == 0;
    }

}
