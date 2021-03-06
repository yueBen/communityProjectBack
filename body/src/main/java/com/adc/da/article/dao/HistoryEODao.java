package com.adc.da.article.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.article.entity.HistoryEO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * <br>
 * <b>功能：</b>history HistoryEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface HistoryEODao extends BaseDao<HistoryEO> {

    /**
     * 验重
     * @param uId
     * @param aId
     * @return
     */
    int repeat(@Param("uid") String uId, @Param("aid") String aId);

}
