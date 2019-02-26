package com.adc.da.textMySqlDB.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>user UserEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-02-26 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserEO extends BaseEntity {

    private String uid;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String username;
    private String userpwd;
    private Integer role;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>uid -> uid</li>
     * <li>createTime -> createTime</li>
     * <li>username -> username</li>
     * <li>userpwd -> userpwd</li>
     * <li>role -> role</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "uid": return "uid";
            case "createTime": return "createTime";
            case "username": return "username";
            case "userpwd": return "userpwd";
            case "role": return "role";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>uid -> uid</li>
     * <li>createTime -> createTime</li>
     * <li>username -> username</li>
     * <li>userpwd -> userpwd</li>
     * <li>role -> role</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "uid": return "uid";
            case "createTime": return "createTime";
            case "username": return "username";
            case "userpwd": return "userpwd";
            case "role": return "role";
            default: return null;
        }
    }
    
    /**  **/
    public String getUid() {
        return this.uid;
    }

    /**  **/
    public void setUid(String uid) {
        this.uid = uid;
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
    public String getUsername() {
        return this.username;
    }

    /**  **/
    public void setUsername(String username) {
        this.username = username;
    }

    /**  **/
    public String getUserpwd() {
        return this.userpwd;
    }

    /**  **/
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    /**  **/
    public Integer getRole() {
        return this.role;
    }

    /**  **/
    public void setRole(Integer role) {
        this.role = role;
    }

}
