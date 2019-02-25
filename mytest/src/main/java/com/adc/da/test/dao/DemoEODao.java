package com.adc.da.test.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.test.entity.DemoEO;
import com.adc.da.test.entity.DemoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>demo DemoEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-09 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface DemoEODao extends BaseDao<DemoEO> {

    List<DemoEO> queryAll();

    List<DemoEO> fuzzyQuery(BasePage basePage);

    List<DemoVo> fuzzyVoQuery(BasePage basePage);

    int deleteAByaid(String id);

    String queryidByAid(String aid);

    int insertAById(@Param("aid") String aid,@Param("uid") String uid,@Param("pid") String pid);
}
