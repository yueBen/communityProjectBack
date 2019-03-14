package com.adc.da.personInfo.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.personInfo.dao.PersonInfoEODao;
import com.adc.da.personInfo.page.NoticeEOPage;
import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.personInfo.dao.NoticeEODao;
import com.adc.da.personInfo.entity.NoticeEO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <br>
 * <b>功能：</b>notice NoticeEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("noticeEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class NoticeEOService extends BaseService<NoticeEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(NoticeEOService.class);

    @Autowired
    private NoticeEODao dao;

    @Autowired
    private PersonInfoEODao pdao;

    public NoticeEODao getDao() {
        return dao;
    }

    /**
     * 一键已读
     *
     * @return
     */
    @Transactional
    public int readAll() {
        return dao.readAll();
    }

    /**
     * 删除已读
     *
     * @return
     */
    @Transactional
    public int readDel() {
        return dao.readDel();
    }

    /**
     * 根据id对通知进行操作
     *
     * @param id
     * @param is
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @Transactional
    public boolean delReadById(String id, String is) {
        return dao.delReadById(id, is) == 1;
    }

    /**
     * 添加通知
     *
     * @param noticeEO
     * @return
     * @author yueben
     * 2019-03-14
     **/
    @Transactional
    public int insertSelect(NoticeEO noticeEO) {
        noticeEO.setId(UUID.randomUUID());
        noticeEO.setCreateTime(new Date());
        noticeEO.setIsRead(0);
        return dao.insertSelective(noticeEO);
    }

    public List<NoticeEO> queryPage(NoticeEOPage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        List<NoticeEO> noticeEOS = dao.queryByPage(page);
        for (NoticeEO eo : noticeEOS) {
            String name = pdao.getPersonByUid(eo.getUId2()).getName();
            eo.setContent(name + "");

        }

        return noticeEOS;
    }

}
