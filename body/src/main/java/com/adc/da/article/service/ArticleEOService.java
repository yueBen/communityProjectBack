package com.adc.da.article.service;

import com.adc.da.article.entity.vo.HistoryVo;
import com.adc.da.article.page.ArticleEOPage;
import com.adc.da.base.page.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.article.dao.ArticleEODao;
import com.adc.da.article.entity.ArticleEO;

import java.util.List;


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

    @Transactional(readOnly = true)
    public List<HistoryVo> queryHisList(HistoryVo historyVo) {
        return dao.queryHisList(historyVo);
    }

    @Transactional(readOnly = true)
    public List<ArticleEO> getFriItems(ArticleEOPage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount.intValue());
        return dao.getFriItems(page);
    }

    @Transactional(readOnly = true)
    public List<ArticleEO> getAttentionItem(ArticleEOPage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount.intValue());
        return dao.getAttentionItem(page);
    }

    @Transactional(readOnly = true)
    public List<ArticleEO> getAdminReview() throws Exception {
        return dao.getAdminReview();
    }

    @Transactional(readOnly = true)
    public List<ArticleEO> queryArticleRanking(ArticleEOPage page) throws Exception {

        return dao.queryArticleRanking(page);
    }

    @Transactional(readOnly = true)
    public int getArticleNum(String uid) throws Exception {

        return dao.getArticleNum(uid);
    }

    @Transactional(readOnly = true)
    public int getBrowseNum(String uid) throws Exception {

        return dao.getBrowseNum(uid);
    }

    @Transactional(readOnly = true)
    public int getCollecNum(String uid) throws Exception {

        return dao.getCollecNum(uid);
    }

    @Transactional(readOnly = true)
    public int getLikeNum(String uid) throws Exception {

        return dao.getLikeNum(uid);
    }

}
