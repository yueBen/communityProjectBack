package com.adc.da.article.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HistoryVo {

    private String id;
    private String uId;
    private String aId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date browseTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date browseTimeStart;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date browseTimeEnd;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;
    private String title;
    private String content;
    private Integer browseNum;
    private Integer collectionNum;
    private Integer commentNum;
    private Integer type;
    private String authorPhoto;
    private String articleImg;
    private String authorName;

    public Date getBrowseTimeStart() {
        return browseTimeStart;
    }

    public void setBrowseTimeStart(Date browseTimeStart) {
        this.browseTimeStart = browseTimeStart;
    }

    public Date getBrowseTimeEnd() {
        return browseTimeEnd;
    }

    public void setBrowseTimeEnd(Date browseTimeEnd) {
        this.browseTimeEnd = browseTimeEnd;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public Date getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }
}
