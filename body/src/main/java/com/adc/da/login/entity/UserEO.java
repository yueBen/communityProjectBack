package com.adc.da.login.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>user UserEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserEO extends BaseEntity {

    private String id;
    private String userName;
    private String userPwd;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date onlineTime;
    private Integer status;
    private Integer accountLevel;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>userName -> user_name</li>
     * <li>userPwd -> user_pwd</li>
     * <li>createTime -> create_time</li>
     * <li>onlineTime -> online_time</li>
     * <li>status -> status</li>
     * <li>accountLevel -> account_level</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "userName": return "user_name";
            case "userPwd": return "user_pwd";
            case "createTime": return "create_time";
            case "onlineTime": return "online_time";
            case "status": return "status";
            case "accountLevel": return "account_level";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>user_name -> userName</li>
     * <li>user_pwd -> userPwd</li>
     * <li>create_time -> createTime</li>
     * <li>online_time -> onlineTime</li>
     * <li>status -> status</li>
     * <li>account_level -> accountLevel</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "user_name": return "userName";
            case "user_pwd": return "userPwd";
            case "create_time": return "createTime";
            case "online_time": return "onlineTime";
            case "status": return "status";
            case "account_level": return "accountLevel";
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
    public String getUserName() {
        return this.userName;
    }

    /**  **/
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**  **/
    public String getUserPwd() {
        return this.userPwd;
    }

    /**  **/
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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
    public Date getOnlineTime() {
        return this.onlineTime;
    }

    /**  **/
    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
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
    public Integer getAccountLevel() {
        return this.accountLevel;
    }

    /**  **/
    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

}
