package com.adc.da.personInfo.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.personInfo.entity.PersonInfoEO;
import org.springframework.data.repository.query.Param;

/**
 *
 * <br>
 * <b>功能：</b>person_info PersonInfoEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface PersonInfoEODao extends BaseDao<PersonInfoEO> {

    PersonInfoEO getPersonByUid(@Param("id") String uid);
}
