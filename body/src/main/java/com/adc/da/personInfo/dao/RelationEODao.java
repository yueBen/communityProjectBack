package com.adc.da.personInfo.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.personInfo.entity.RelationEO;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>relation RelationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface RelationEODao extends BaseDao<RelationEO> {


    /**
    * 通过/拒绝好友请求，取消关注
     * @param relationEO
    * @return
    * @author yueben
    * 2019-03-14
    **/
    int updateRelation(RelationEO relationEO);


    /**
    * 好友查重
     * @param relationEO
    * @return
    * @author yueben
    * 2019-03-14
    **/
    int repeatFriend(RelationEO relationEO);

    /**
    * 关注查重
     * @param relationEO
    * @return
    * @author yueben
    * 2019-03-14
    **/
    int repeatAtten(RelationEO relationEO);



}
