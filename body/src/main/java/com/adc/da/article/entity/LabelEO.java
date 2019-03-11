package com.adc.da.article.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>label LabelEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class LabelEO extends BaseEntity {

    private String id;
    private String uId;
    private Integer num;
    private String labelName;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>uId -> u_id</li>
     * <li>num -> num</li>
     * <li>labelName -> label_name</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "uId": return "u_id";
            case "num": return "num";
            case "labelName": return "label_name";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>u_id -> uId</li>
     * <li>num -> num</li>
     * <li>label_name -> labelName</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "u_id": return "uId";
            case "num": return "num";
            case "label_name": return "labelName";
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
    public Integer getNum() {
        return this.num;
    }

    /**  **/
    public void setNum(Integer num) {
        this.num = num;
    }

    /**  **/
    public String getLabelName() {
        return this.labelName;
    }

    /**  **/
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

}
