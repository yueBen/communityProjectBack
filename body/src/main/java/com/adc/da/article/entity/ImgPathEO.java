package com.adc.da.article.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>img_path ImgPathEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-17 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ImgPathEO extends BaseEntity {

    private String id;
    private String imgName;
    private String suffix;
    private String path;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>imgName -> imgName</li>
     * <li>suffix -> suffix</li>
     * <li>path -> path</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "imgName": return "imgName";
            case "suffix": return "suffix";
            case "path": return "path";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>imgName -> imgName</li>
     * <li>suffix -> suffix</li>
     * <li>path -> path</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "imgName": return "imgName";
            case "suffix": return "suffix";
            case "path": return "path";
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
    public String getImgName() {
        return this.imgName;
    }

    /**  **/
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**  **/
    public String getSuffix() {
        return this.suffix;
    }

    /**  **/
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**  **/
    public String getPath() {
        return this.path;
    }

    /**  **/
    public void setPath(String path) {
        this.path = path;
    }

}
