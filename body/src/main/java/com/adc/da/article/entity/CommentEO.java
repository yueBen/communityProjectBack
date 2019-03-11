package com.adc.da.article.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>comment CommentEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class CommentEO extends BaseEntity {

    private String id;
    private String uId;
    private String onId;
    private String pId;
    private Integer type;
    private Integer likeNum;
    private Integer dislikeNum;
    private Integer commentNum;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String content;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>onId -> on_id</li>
     * <li>pId -> p_id</li>
     * <li>type -> type</li>
     * <li>likeNum -> like_num</li>
     * <li>dislikeNum -> dislike_num</li>
     * <li>commentNum -> comment_num</li>
     * <li>createTime -> create_time</li>
     * <li>content -> content</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "onId": return "on_id";
            case "pId": return "p_id";
            case "type": return "type";
            case "likeNum": return "like_num";
            case "dislikeNum": return "dislike_num";
            case "commentNum": return "comment_num";
            case "createTime": return "create_time";
            case "content": return "content";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>on_id -> onId</li>
     * <li>p_id -> pId</li>
     * <li>type -> type</li>
     * <li>like_num -> likeNum</li>
     * <li>dislike_num -> dislikeNum</li>
     * <li>comment_num -> commentNum</li>
     * <li>create_time -> createTime</li>
     * <li>content -> content</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "on_id": return "onId";
            case "p_id": return "pId";
            case "type": return "type";
            case "like_num": return "likeNum";
            case "dislike_num": return "dislikeNum";
            case "comment_num": return "commentNum";
            case "create_time": return "createTime";
            case "content": return "content";
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
    public String getOnId() {
        return this.onId;
    }

    /**  **/
    public void setOnId(String onId) {
        this.onId = onId;
    }

    /**  **/
    public String getPId() {
        return this.pId;
    }

    /**  **/
    public void setPId(String pId) {
        this.pId = pId;
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
    public Integer getLikeNum() {
        return this.likeNum;
    }

    /**  **/
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**  **/
    public Integer getDislikeNum() {
        return this.dislikeNum;
    }

    /**  **/
    public void setDislikeNum(Integer dislikeNum) {
        this.dislikeNum = dislikeNum;
    }

    /**  **/
    public Integer getCommentNum() {
        return this.commentNum;
    }

    /**  **/
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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

}
