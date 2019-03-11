package com.adc.da.article.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>label LabelEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class LabelEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String uId;
    private String uIdOperator = "=";
    private String num;
    private String numOperator = "=";
    private String labelName;
    private String labelNameOperator = "=";

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

    public String getUId() {
        return this.uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getUIdOperator() {
        return this.uIdOperator;
    }

    public void setUIdOperator(String uIdOperator) {
        this.uIdOperator = uIdOperator;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNumOperator() {
        return this.numOperator;
    }

    public void setNumOperator(String numOperator) {
        this.numOperator = numOperator;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelNameOperator() {
        return this.labelNameOperator;
    }

    public void setLabelNameOperator(String labelNameOperator) {
        this.labelNameOperator = labelNameOperator;
    }

}
