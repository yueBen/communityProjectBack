package com.adc.da.personInfo.service;

import com.adc.da.personInfo.dao.PersonInfoEODao;
import com.adc.da.personInfo.page.StickyNoteEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.personInfo.dao.StickyNoteEODao;
import com.adc.da.personInfo.entity.StickyNoteEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>sticky_note StickyNoteEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("stickyNoteEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class StickyNoteEOService extends BaseService<StickyNoteEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(StickyNoteEOService.class);

    @Autowired
    private StickyNoteEODao dao;

    @Autowired
    private PersonInfoEODao pdao;

    public StickyNoteEODao getDao() {
        return dao;
    }

    @Transactional
    public List<StickyNoteEO> queryList(StickyNoteEOPage page) {
        Integer rowCount = dao.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        List<StickyNoteEO> stickyNoteEOS = dao.queryByPage(page);

        for (int i = 0; i < stickyNoteEOS.size(); i++) {
            stickyNoteEOS.get(i).setUId2(pdao.getPersonByUid(stickyNoteEOS.get(i).getUId1()).getName());
        }
        return stickyNoteEOS;
    }

}
