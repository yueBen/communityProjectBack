package com.adc.da.article.dao;

import com.adc.da.article.entity.vo.HistoryVo;
import com.adc.da.article.page.ArticleEOPage;
import com.adc.da.base.dao.BaseDao;
import com.adc.da.article.entity.ArticleEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>article ArticleEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface ArticleEODao extends BaseDao<ArticleEO> {

    /**
     * 历史记录
     * @param historyVo
     * @return
     */
    List<HistoryVo> queryHisList(HistoryVo historyVo);

    /**
     *  好友文章加载
     * @param page
     * @return
     */
    List<ArticleEO> getFriItems(ArticleEOPage page);

    List<ArticleEO> getAttentionItem(ArticleEOPage page);

    List<ArticleEO> queryArticleRanking(ArticleEOPage page);

    List<ArticleEO> getAdminReview();

    int getArticleNum(String uid);

    int getBrowseNum(String uid);

    int getCollecNum(String uid);

    int getLikeNum(String uid);

}
