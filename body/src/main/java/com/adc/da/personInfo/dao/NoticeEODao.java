package com.adc.da.personInfo.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.personInfo.entity.NoticeEO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * <br>
 * <b>功能：</b>notice NoticeEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface NoticeEODao extends BaseDao<NoticeEO> {


    /**
     * 一键已读
     * @return
     */
    int readAll();

    /**
     * 删除已读
     * @return
     */
    int readDel();

    /**
     * 根据id进行删除和已读
     * 多个参数使用@Param，在mapper.xml中就不要申明参数
     * @param id
     * @param isRead
     * @return
     */
    int delReadById(@Param("id") String id, @Param("is") String isRead);

}
