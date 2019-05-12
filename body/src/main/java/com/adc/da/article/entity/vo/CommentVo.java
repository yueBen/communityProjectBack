package com.adc.da.article.entity.vo;

import java.util.Date;

public class CommentVo {

    private String id;
    private String uid;
    private String pid;
    private int like;
    private int dislike;
    private String content;
    private String nameA;
    private String nameB;
    private Date time;
    private int comentNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getComentNum() {
        return comentNum;
    }

    public void setComentNum(int comentNum) {
        this.comentNum = comentNum;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
