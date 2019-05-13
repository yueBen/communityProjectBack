package com.adc.da.login.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.login.entity.UserEO;
import com.adc.da.login.entity.UserVO;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>user UserEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface UserEODao extends BaseDao<UserEO> {

    /**
    * 用户登录验证
     * @param user
    * @return
    * @author yueben
    * 2019-03-12
    **/
    List<UserEO> userLogin(UserEO user);

    /**
    * 用户名验重
     * @param username
    * @return
    * @author yueben
    * 2019-03-12
    **/
    int userNameCheck(String username);

    List<UserVO> getUserList(UserVO vo);

}
