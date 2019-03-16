package com.adc.da.article.entity;

import com.adc.da.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <b>功能：</b>history HistoryEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class HistoryEO extends BaseEntity {

    private String id;
    private String uId;
    private String aId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date browseTime;
    private String authorPhoto;
    private String articleImg;
    private String authorName;
    private String content;
    private Integer browseNum;
    private Integer collectionNum;
    private Integer commentNum;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>aId -> a_id</li>
     * <li>browseTime -> browse_time</li>
     * <li>authorPhoto -> author_photo</li>
     * <li>articleImg -> article_img</li>
     * <li>authorName -> author_name</li>
     * <li>content -> content</li>
     * <li>browseNum -> browse_num</li>
     * <li>collectionNum -> collection_num</li>
     * <li>commentNum -> comment_num</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "aId": return "a_id";
            case "browseTime": return "browse_time";
            case "authorPhoto": return "author_photo";
            case "articleImg": return "article_img";
            case "authorName": return "author_name";
            case "content": return "content";
            case "browseNum": return "browse_num";
            case "collectionNum": return "collection_num";
            case "commentNum": return "comment_num";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>a_id -> aId</li>
     * <li>browse_time -> browseTime</li>
     * <li>author_photo -> authorPhoto</li>
     * <li>article_img -> articleImg</li>
     * <li>author_name -> authorName</li>
     * <li>content -> content</li>
     * <li>browse_num -> browseNum</li>
     * <li>collection_num -> collectionNum</li>
     * <li>comment_num -> commentNum</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "a_id": return "aId";
            case "browse_time": return "browseTime";
            case "author_photo": return "authorPhoto";
            case "article_img": return "articleImg";
            case "author_name": return "authorName";
            case "content": return "content";
            case "browse_num": return "browseNum";
            case "collection_num": return "collectionNum";
            case "comment_num": return "commentNum";
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
    public String getAId() {
        return this.aId;
    }

    /**  **/
    public void setAId(String aId) {
        this.aId = aId;
    }

    /**  **/
    public Date getBrowseTime() {
        return this.browseTime;
    }

    /**  **/
    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    /**  **/
    public String getAuthorPhoto() {
        return this.authorPhoto;
    }

    /**  **/
    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    /**  **/
    public String getArticleImg() {
        return this.articleImg;
    }

    /**  **/
    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    /**  **/
    public String getAuthorName() {
        return this.authorName;
    }

    /**  **/
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

}
