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
        String uid = page.getId();
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        List<NoticeEO> noticeEOS = dao.queryByPage(page);
        ArrayList<NoticeEO> list = new ArrayList<>();
        for (NoticeEO eo : noticeEOS) {
            Integer status = eo.getStatus();
            Integer type = eo.getType();
            //主动通知，我怎么怎么了
            if (eo.getUId1().equals(uid)) {
                String name = pdao.getPersonByUid(eo.getUId2()).getName();
                switch (type) {
                    case 0:
                        eo.setContent(status == 0?"已向&nbsp;&nbsp;"+name+"&nbsp;&nbsp;发出好友申请！":
                                status == 1? "您与&nbsp;&nbsp;"+name+"&nbsp;&nbsp;已经是好友了！":
                                status == 2? name+"&nbsp;&nbsp;拒绝了您的邀请！":
                                status == 3? "您与&nbsp;&nbsp;"+name+"&nbsp;&nbsp;解除了好友关系！":"介是嘛？A");break;
                    case 3:
                        eo.setContent(status == 0?"您已关注了："+name:"您取消关注了："+name);break;
                }
            } else {
                //被动通知，谁怎么怎么了我
                String name = pdao.getPersonByUid(eo.getUId1()).getName();
                switch (type) {
                    case 0:
                        eo.setContent(status == 0?name+"&nbsp;&nbsp;想和你成为好友。<div class='item-title-btn i-b-left'>详情</div>":
                                status == 3?name+"与您解除了好友关系！":"介是嘛？B");break;
                    case 1:
                        eo.setContent(status == 0||status == 1?"您有了新的评论。<div class='item-title-btn i-b-left'>详情</div>":
                                status == 2?name+"&nbsp;&nbsp;给您的评论点了赞。<div class='item-title-btn i-b-left'>详情</div>":
                                status == 3?name+"&nbsp;&nbsp;不喜欢您的评论。<div class='item-title-btn i-b-left'>详情</div>":"介是嘛？C");
                        break;
                    case 2:
                        eo.setContent(status == 0?name+"&nbsp;&nbsp;收藏了您的文章。<div class='item-title-btn i-b-left'>详情</div>":
                                status == 1?name+"&nbsp;&nbsp;给您的文章点了赞。<div class='item-title-btn i-b-left'>详情</div>":
                                status == 2?name+"&nbsp;&nbsp;不喜欢您的文章。<div class='item-title-btn i-b-left'>详情</div>":"介是嘛？D");
                        break;
                    case 3:
                        eo.setContent(status == 0?name+"&nbsp;&nbsp;关注了您！":
                                status == 1?name+"&nbsp;&nbsp;取消关注了您！":"介是嘛？E");
                        break;
                    case 4:
                        eo.setContent(name+"&nbsp;&nbsp;给您留言了！");
                }
            }
            list.add(eo);
        }

        return list;
    }



}
