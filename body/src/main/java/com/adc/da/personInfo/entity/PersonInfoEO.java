package com.adc.da.personInfo.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>person_info PersonInfoEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class PersonInfoEO extends BaseEntity {

    private String id;
    private String uId;
    private String name;
    private String phone;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String address;
    private String gender;
    private String introduce;
    private Integer ranking;
    private Integer praiseNum;
    private Integer commentNum;
    private Integer messageNum;
    private Integer browseNum;
    private String photoPath;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>name -> name</li>
     * <li>phone -> phone</li>
     * <li>birthday -> birthday</li>
     * <li>address -> address</li>
     * <li>gender -> gender</li>
     * <li>introduce -> introduce</li>
     * <li>ranking -> ranking</li>
     * <li>praiseNum -> praise_num</li>
     * <li>photoPath -> photo_path</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "name": return "name";
            case "phone": return "phone";
            case "birthday": return "birthday";
            case "address": return "address";
            case "gender": return "gender";
            case "introduce": return "introduce";
            case "ranking": return "ranking";
            case "praiseNum": return "praise_num";
            case "commentNum": return "comment_num";
            case "messageNum": return "message_num";
            case "browseNum": return "browse_num";
            case "photoPath": return "photo_path";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>name -> name</li>
     * <li>phone -> phone</li>
     * <li>birthday -> birthday</li>
     * <li>address -> address</li>
     * <li>gender -> gender</li>
     * <li>introduce -> introduce</li>
     * <li>ranking -> ranking</li>
     * <li>praise_num -> praiseNum</li>
     * <li>photo_path -> photoPath</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "name": return "name";
            case "phone": return "phone";
            case "birthday": return "birthday";
            case "address": return "address";
            case "gender": return "gender";
            case "introduce": return "introduce";
            case "ranking": return "ranking";
            case "praise_num": return "praiseNum";
            case "comment_num": return "commentNum";
            case "message_num": return "messageNum";
            case "browse_num": return "browseNum";
            case "photo_path": return "photoPath";
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
    public String getName() {
        return this.name;
    }

    /**  **/
    public void setName(String name) {
        this.name = name;
    }

    /**  **/
    public String getPhone() {
        return this.phone;
    }

    /**  **/
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**  **/
    public Date getBirthday() {
        return this.birthday;
    }

    /**  **/
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**  **/
    public String getAddress() {
        return this.address;
    }

    /**  **/
    public void setAddress(String address) {
        this.address = address;
    }

    /**  **/
    public String getGender() {
        return this.gender;
    }

    /**  **/
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**  **/
    public String getIntroduce() {
        return this.introduce;
    }

    /**  **/
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**  **/
    public Integer getRanking() {
        return this.ranking;
    }

    /**  **/
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    /**  **/
    public Integer getPraiseNum() {
        return this.praiseNum;
    }

    /**  **/
    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    /**  **/
    public String getPhotoPath() {
        return this.photoPath;
    }

    /**  **/
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }
}
