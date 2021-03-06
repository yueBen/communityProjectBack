package com.adc.da.admin.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.admin.entity.LexiconEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>lexicon LexiconEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface LexiconEODao extends BaseDao<LexiconEO> {

    int repeat(String name);

}
