package com.adc.da.order.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>TS_ORDER OrderEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-07-19 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class OrderEO extends BaseEntity {

    private String procInstId;
    private String userId;
    private String status;
    private Long orderId;
    private String title;
    private String content;
    private String orderType;
    private Double orderSum;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>procInstId -> proc_inst_id_</li>
     * <li>userId -> user_id</li>
     * <li>status -> status</li>
     * <li>orderId -> order_id</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>orderType -> order_type</li>
     * <li>orderSum -> order_sum</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "procInstId": return "proc_inst_id_";
            case "userId": return "user_id";
            case "status": return "status";
            case "orderId": return "order_id";
            case "title": return "title";
            case "content": return "content";
            case "orderType": return "order_type";
            case "orderSum": return "order_sum";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>proc_inst_id_ -> procInstId</li>
     * <li>user_id -> userId</li>
     * <li>status -> status</li>
     * <li>order_id -> orderId</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>order_type -> orderType</li>
     * <li>order_sum -> orderSum</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "proc_inst_id_": return "procInstId";
            case "user_id": return "userId";
            case "status": return "status";
            case "order_id": return "orderId";
            case "title": return "title";
            case "content": return "content";
            case "order_type": return "orderType";
            case "order_sum": return "orderSum";
            default: return null;
        }
    }
    
    /**  **/
    public String getProcInstId() {
        return this.procInstId;
    }

    /**  **/
    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    /**  **/
    public String getUserId() {
        return this.userId;
    }

    /**  **/
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**  **/
    public String getStatus() {
        return this.status;
    }

    /**  **/
    public void setStatus(String status) {
        this.status = status;
    }

    /**  **/
    public Long getOrderId() {
        return this.orderId;
    }

    /**  **/
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**  **/
    public String getTitle() {
        return this.title;
    }

    /**  **/
    public void setTitle(String title) {
        this.title = title;
    }

    /**  **/
    public String getContent() {
        return this.content;
    }

    /**  **/
    public void setContent(String content) {
        this.content = content;
    }

    /**  **/
    public String getOrderType() {
        return this.orderType;
    }

    /**  **/
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**  **/
    public Double getOrderSum() {
        return this.orderSum;
    }

    /**  **/
    public void setOrderSum(Double orderSum) {
        this.orderSum = orderSum;
    }

}
