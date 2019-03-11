package com.adc.da.article.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.article.dao.ArticleEODao;
import com.adc.da.article.entity.ArticleEO;


/**
 *
 * <br>
 * <b>功能：</b>article ArticleEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("articleEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ArticleEOService extends BaseService<ArticleEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(ArticleEOService.class);

    @Autowired
    private ArticleEODao dao;

    public ArticleEODao getDao() {
        return dao;
    }

}
