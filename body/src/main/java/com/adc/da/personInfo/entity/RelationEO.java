package com.adc.da.personInfo.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>relation RelationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class RelationEO extends BaseEntity {

    private String id;
    private String uId1;
    private String uId2;
    private String note;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer type;
    private Integer status;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId1 -> u_id_1</li>
     * <li>uId2 -> u_id_2</li>
     * <li>note -> note</li>
     * <li>createTime -> create_time</li>
     * <li>type -> type</li>
     * <li>status -> status</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId1": return "u_id_1";
            case "uId2": return "u_id_2";
            case "note": return "note";
            case "createTime": return "create_time";
            case "type": return "type";
            case "status": return "status";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id_1 -> uId1</li>
     * <li>u_id_2 -> uId2</li>
     * <li>note -> note</li>
     * <li>create_time -> createTime</li>
     * <li>type -> type</li>
     * <li>status -> status</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id_1": return "uId1";
            case "u_id_2": return "uId2";
            case "note": return "note";
            case "create_time": return "createTime";
            case "type": return "type";
            case "status": return "status";
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
    public String getNote() {
        return this.note;
    }

    /**  **/
    public void setNote(String note) {
        this.note = note;
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
    public Integer getType() {
        return this.type;
    }

    /**  **/
    public void setType(Integer type) {
        this.type = type;
    }

    /**  **/
    public Integer getStatus() {
        return this.status;
    }

    /**  **/
    public void setStatus(Integer status) {
        this.status = status;
    }

}
