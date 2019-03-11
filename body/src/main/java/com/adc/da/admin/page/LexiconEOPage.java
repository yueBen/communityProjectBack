package com.adc.da.admin.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>lexicon LexiconEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class LexiconEOPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String word;
    private String wordOperator = "=";
    private String level;
    private String levelOperator = "=";

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

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordOperator() {
        return this.wordOperator;
    }

    public void setWordOperator(String wordOperator) {
        this.wordOperator = wordOperator;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelOperator() {
        return this.levelOperator;
    }

    public void setLevelOperator(String levelOperator) {
        this.levelOperator = levelOperator;
    }

}
