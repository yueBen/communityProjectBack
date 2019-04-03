package com.adc.da.article.service;

import org.apache.el.parser.BooleanNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.article.dao.LabelEODao;
import com.adc.da.article.entity.LabelEO;


/**
 *
 * <br>
 * <b>功能：</b>label LabelEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("labelEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class LabelEOService extends BaseService<LabelEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(LabelEOService.class);

    @Autowired
    private LabelEODao dao;

    public LabelEODao getDao() {
        return dao;
    }

    @Transactional
    public int setLabelNum(String uid, String id) {
        return dao.setLabelNum(uid, id);
    }

    @Transactional
    public boolean isLabelNameRepeat(String labelName) {
        return dao.isLabelNameRepeat(labelName) < 1;
    }

}
