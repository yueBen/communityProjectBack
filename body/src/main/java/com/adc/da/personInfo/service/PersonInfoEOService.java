package com.adc.da.personInfo.service;

import com.adc.da.FileUpLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.personInfo.dao.PersonInfoEODao;
import com.adc.da.personInfo.entity.PersonInfoEO;

import java.util.List;


/**
 * <br>
 * <b>功能：</b>person_info PersonInfoEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("personInfoEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class PersonInfoEOService extends BaseService<PersonInfoEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(PersonInfoEOService.class);

    @Autowired
    private PersonInfoEODao dao;

    public PersonInfoEODao getDao() {
        return dao;
    }

    /**
     *
     * @param uid
     * @return
     * @author yueben
     * 2019-03-13
     **/
    @Transactional(readOnly = true)
    public PersonInfoEO getPersonByUid(String uid) {
        return dao.getPersonByUid(uid);
    }

    @Transactional(readOnly = true)
    public List<PersonInfoEO> SelAddUser(PersonInfoEO eo) {
        return dao.SelAddUser(eo);
    }

    @Transactional(readOnly = true)
    public List<PersonInfoEO> getUser(PersonInfoEO eo) {
        return dao.getUser(eo);
    }

}
