package com.adc.da.article.entity;

import com.adc.da.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <b>功能：</b>article ArticleEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ArticleEO extends BaseEntity {

    private String id;
    private String uId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date releaseTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private Integer status;
    private String title;
    private String content;
    private Integer browseNum = Integer.valueOf(0);
    private Integer collectionNum = Integer.valueOf(0);
    private Integer commentNum = Integer.valueOf(0);
    private Integer likeNum = Integer.valueOf(0);
    private Integer dislikeNum = Integer.valueOf(0);
    private String labelId;
    private Integer type;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>createTime -> create_time</li>
     * <li>releaseTime -> release_time</li>
     * <li>updateTime -> update_time</li>
     * <li>status -> status</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>browseNum -> browse_num</li>
     * <li>collectionNum -> collection_num</li>
     * <li>commentNum -> comment_num</li>
     * <li>likeNum -> like_num</li>
     * <li>dislikeNum -> dislike_num</li>
     * <li>labelId -> label_id</li>
     * <li>type -> type</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "createTime": return "create_time";
            case "releaseTime": return "release_time";
            case "updateTime": return "update_time";
            case "status": return "status";
            case "title": return "title";
            case "content": return "content";
            case "browseNum": return "browse_num";
            case "collectionNum": return "collection_num";
            case "commentNum": return "comment_num";
            case "likeNum": return "like_num";
            case "dislikeNum": return "dislike_num";
            case "labelId": return "label_id";
            case "type": return "type";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>create_time -> createTime</li>
     * <li>release_time -> releaseTime</li>
     * <li>update_time -> updateTime</li>
     * <li>status -> status</li>
     * <li>title -> title</li>
     * <li>content -> content</li>
     * <li>browse_num -> browseNum</li>
     * <li>collection_num -> collectionNum</li>
     * <li>comment_num -> commentNum</li>
     * <li>like_num -> likeNum</li>
     * <li>dislike_num -> dislikeNum</li>
     * <li>label_id -> labelId</li>
     * <li>type -> type</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "create_time": return "createTime";
            case "release_time": return "releaseTime";
            case "update_time": return "updateTime";
            case "status": return "status";
            case "title": return "title";
            case "content": return "content";
            case "browse_num": return "browseNum";
            case "collection_num": return "collectionNum";
            case "comment_num": return "commentNum";
            case "like_num": return "likeNum";
            case "dislike_num": return "dislikeNum";
            case "label_id": return "labelId";
            case "type": return "type";
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
    public Date getReleaseTime() {
        return this.releaseTime;
    }

    /**  **/
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**  **/
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**  **/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public Integer getBrowseNum() {
        return this.browseNum;
    }

    /**  **/
    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    /**  **/
    public Integer getCollectionNum() {
        return this.collectionNum;
    }

    /**  **/
    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
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
    public String getLabelId() {
        return this.labelId;
    }

    /**  **/
    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    /**  **/
    public Integer getType() {
        return this.type;
    }

    /**  **/
    public void setType(Integer type) {
        this.type = type;
    }

}
