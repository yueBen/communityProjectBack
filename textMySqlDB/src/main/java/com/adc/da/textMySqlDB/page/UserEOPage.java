package com.adc.da.textMySqlDB.page;

import com.adc.da.base.page.BasePage;

import java.util.Date;

/**
 * <b>功能：</b>user UserEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-02-26 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserEOPage extends BasePage {

    private String uid;
    private String uidOperator = "=";
    private String createTime;
    private String createTime1;
    private String createTime2;
    private String createTimeOperator = "=";
    private String username;
    private String usernameOperator = "=";
    private String userpwd;
    private String userpwdOperator = "=";
    private String role;
    private String roleOperator = "=";

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUidOperator() {
        return this.uidOperator;
    }

    public void setUidOperator(String uidOperator) {
        this.uidOperator = uidOperator;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameOperator() {
        return this.usernameOperator;
    }

    public void setUsernameOperator(String usernameOperator) {
        this.usernameOperator = usernameOperator;
    }

    public String getUserpwd() {
        return this.userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserpwdOperator() {
        return this.userpwdOperator;
    }

    public void setUserpwdOperator(String userpwdOperator) {
        this.userpwdOperator = userpwdOperator;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleOperator() {
        return this.roleOperator;
    }

    public void setRoleOperator(String roleOperator) {
        this.roleOperator = roleOperator;
    }

}
