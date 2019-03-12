package com.adc.da.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.login.dao.UserEODao;
import com.adc.da.login.entity.UserEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>user UserEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("userEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserEOService extends BaseService<UserEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(UserEOService.class);

    @Autowired
    private UserEODao dao;

    public UserEODao getDao() {
        return dao;
    }

    /**
    * 用户登录
     * @param user
    * @return
    * @author yueben
    * 2019-03-12
    **/
    @Transactional(readOnly = true)
    public UserEO userLogin(UserEO user) {
        List<UserEO> userEOS = dao.userLogin(user);
        if (userEOS.size() == 1) {
            return userEOS.get(0);
        } else {
            return null;
        }
    }

    /**
    * 用户名验重
     * @param name
    * @return
    * @author yueben
    * 2019-03-12
    **/
    @Transactional(readOnly = true)
    public boolean usernameCheck(String name) {
        return dao.userNameCheck(name) == 0;
    }

}
