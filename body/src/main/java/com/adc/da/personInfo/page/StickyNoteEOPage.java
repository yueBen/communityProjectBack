package com.adc.da.personInfo.page;

import com.adc.da.base.page.BasePage;

import java.util.Date;

/**
 * <b>功能：</b>sticky_note StickyNoteEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class StickyNoteEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String uId1;
    private String uId1Operator = "=";
    private String uId2;
    private String uId2Operator = "=";
    private String createTime;
    private String createTime1;
    private String createTime2;
    private String createTimeOperator = "=";
    private String status;
    private String statusOperator = "=";
    private String content;
    private String contentOperator = "=";

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return this.idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getUId1() {
        return this.uId1;
    }

    public void setUId1(String uId1) {
        this.uId1 = uId1;
    }

    public String getUId1Operator() {
        return this.uId1Operator;
    }

    public void setUId1Operator(String uId1Operator) {
        this.uId1Operator = uId1Operator;
    }

    public String getUId2() {
        return this.uId2;
    }

    public void setUId2(String uId2) {
        this.uId2 = uId2;
    }

    public String getUId2Operator() {
        return this.uId2Operator;
    }

    public void setUId2Operator(String uId2Operator) {
        this.uId2Operator = uId2Operator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime1() {
        return this.createTime1;
    }

    public void setCreateTime1(String createTime1) {
        this.createTime1 = createTime1;
    }

    public String getCreateTime2() {
        return this.createTime2;
    }

    public void setCreateTime2(String createTime2) {
        this.createTime2 = createTime2;
    }

    public String getCreateTimeOperator() {
        return this.createTimeOperator;
    }

    public void setCreateTimeOperator(String createTimeOperator) {
        this.createTimeOperator = createTimeOperator;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusOperator() {
        return this.statusOperator;
    }

    public void setStatusOperator(String statusOperator) {
        this.statusOperator = statusOperator;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentOperator() {
        return this.contentOperator;
    }

    public void setContentOperator(String contentOperator) {
        this.contentOperator = contentOperator;
    }

}
