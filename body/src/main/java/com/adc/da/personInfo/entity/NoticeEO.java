package com.adc.da.personInfo.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>notice NoticeEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class NoticeEO extends BaseEntity {

    private String id;
    private String uId;
    private String toId;
    private Integer type;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String content;
    private Integer satus;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>toId -> to_id</li>
     * <li>type -> type</li>
     * <li>createTime -> create_time</li>
     * <li>content -> content</li>
     * <li>satus -> satus</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "toId": return "to_id";
            case "type": return "type";
            case "createTime": return "create_time";
            case "content": return "content";
            case "satus": return "satus";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>to_id -> toId</li>
     * <li>type -> type</li>
     * <li>create_time -> createTime</li>
     * <li>content -> content</li>
     * <li>satus -> satus</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "to_id": return "toId";
            case "type": return "type";
            case "create_time": return "createTime";
            case "content": return "content";
            case "satus": return "satus";
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
    public String getUId() {
        return this.uId;
    }

    /**  **/
    public void setUId(String uId) {
        this.uId = uId;
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
    public Integer getSatus() {
        return this.satus;
    }

    /**  **/
    public void setSatus(Integer satus) {
        this.satus = satus;
    }

}
