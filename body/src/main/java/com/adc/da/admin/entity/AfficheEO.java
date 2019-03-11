package com.adc.da.admin.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>affiche AfficheEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class AfficheEO extends BaseEntity {

    private String id;
    private String uId;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer type;
    private String title;
    private String content;
    private String phontPath;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>createTime -> create_time</li>
     * <li>type -> type</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>phontPath -> phont_path</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "createTime": return "create_time";
            case "type": return "type";
            case "title": return "title";
            case "content": return "content";
            case "phontPath": return "phont_path";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>create_time -> createTime</li>
     * <li>type -> type</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>phont_path -> phontPath</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "create_time": return "createTime";
            case "type": return "type";
            case "title": return "title";
            case "content": return "content";
            case "phont_path": return "phontPath";
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
    public String getPhontPath() {
        return this.phontPath;
    }

    /**  **/
    public void setPhontPath(String phontPath) {
        this.phontPath = phontPath;
    }

}
