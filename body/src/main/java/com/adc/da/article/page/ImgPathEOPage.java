package com.adc.da.article.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>img_path ImgPathEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-17 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ImgPathEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String imgName;
    private String imgNameOperator = "=";
    private String suffix;
    private String suffixOperator = "=";
    private String path;
    private String pathOperator = "=";

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return this.idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getImgName() {
        return this.imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgNameOperator() {
        return this.imgNameOperator;
    }

    public void setImgNameOperator(String imgNameOperator) {
        this.imgNameOperator = imgNameOperator;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffixOperator() {
        return this.suffixOperator;
    }

    public void setSuffixOperator(String suffixOperator) {
        this.suffixOperator = suffixOperator;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathOperator() {
        return this.pathOperator;
    }

    public void setPathOperator(String pathOperator) {
        this.pathOperator = pathOperator;
    }

}
