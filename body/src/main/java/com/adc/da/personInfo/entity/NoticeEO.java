package com.adc.da.personInfo.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>notice NoticeEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-13 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class NoticeEO extends BaseEntity {

    private String id;
    private String uId1;
    private String uId2;
    private String toId;
    private Integer type;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String content;
    private Integer status;
    private Integer isRead;

    public NoticeEO(String uId1, String uId2, String toId, Integer type, String content, Integer status) {
        this.uId1 = uId1;
        this.uId2 = uId2;
        this.toId = toId;
        this.type = type;
        this.content = content;
        this.status = status;
    }

    public NoticeEO() {
    }

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId1 -> u_id_1</li>
     * <li>uId2 -> u_id_2</li>
     * <li>toId -> to_id</li>
     * <li>type -> type</li>
     * <li>createTime -> create_time</li>
     * <li>content -> content</li>
     * <li>status -> status</li>
     * <li>isRead -> is_read</li>
     */



    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId1": return "u_id_1";
            case "uId2": return "u_id_2";
            case "toId": return "to_id";
            case "type": return "type";
            case "createTime": return "create_time";
            case "content": return "content";
            case "status": return "status";
            case "isRead": return "is_read";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id_1 -> uId1</li>
     * <li>u_id_2 -> uId2</li>
     * <li>to_id -> toId</li>
     * <li>type -> type</li>
     * <li>create_time -> createTime</li>
     * <li>content -> content</li>
     * <li>status -> status</li>
     * <li>is_read -> isRead</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id_1": return "uId1";
            case "u_id_2": return "uId2";
            case "to_id": return "toId";
            case "type": return "type";
            case "create_time": return "createTime";
            case "content": return "content";
            case "status": return "status";
            case "is_read": return "isRead";
            default: return null;
        }
    }
    
    /**  **/
    public String getId() {
        return this.id;
    }

    /**  **/
    public void setId(String id) {
        this.id = id;
    }

    /**  **/
    public String getUId1() {
        return this.uId1;
    }

    /**  **/
    public void setUId1(String uId1) {
        this.uId1 = uId1;
    }

    /**  **/
    public String getUId2() {
        return this.uId2;
    }

    /**  **/
    public void setUId2(String uId2) {
        this.uId2 = uId2;
    }

    /**  **/
    public String getToId() {
        return this.toId;
    }

    /**  **/
    public void setToId(String toId) {
        this.toId = toId;
    }

    /**  **/
    public Integer getType() {
        return this.type;
    }

    /**  **/
    public void setType(Integer type) {
        this.type = type;
    }

    /**  **/
    public Date getCreateTime() {
        return this.createTime;
    }

    /**  **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    public Integer getStatus() {
        return this.status;
    }

    /**  **/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**  **/
    public Integer getIsRead() {
        return this.isRead;
    }

    /**  **/
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

}
