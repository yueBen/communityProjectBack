package com.adc.da.article.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.article.dao.CommentEODao;
import com.adc.da.article.entity.CommentEO;


/**
 *
 * <br>
 * <b>功能：</b>comment CommentEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("commentEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CommentEOService extends BaseService<CommentEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(CommentEOService.class);

    @Autowired
    private CommentEODao dao;

    public CommentEODao getDao() {
        return dao;
    }

}
