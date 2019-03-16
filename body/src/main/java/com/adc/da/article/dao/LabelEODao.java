package com.adc.da.article.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.article.entity.LabelEO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * <br>
 * <b>功能：</b>label LabelEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface LabelEODao extends BaseDao<LabelEO> {

    int setLabelNum(@Param("uid") String uId, @Param("id") String id);
}
