package com.adc.da.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.admin.dao.LexiconEODao;
import com.adc.da.admin.entity.LexiconEO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * <br>
 * <b>功能：</b>lexicon LexiconEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-03-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("lexiconEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class LexiconEOService extends BaseService<LexiconEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(LexiconEOService.class);

    @Autowired
    private LexiconEODao dao;

    public LexiconEODao getDao() {
        return dao;
    }

    @Transactional(readOnly = true)
    public boolean repeat(String name) {
        return dao.repeat(name) == 0;
    }

    /**
     *      检查文章、评论、留言内容并返回等级
     * @param content
     * @return
     */
    @Transactional(readOnly = true)
    public String checkContent(String content, int type) {
        List<LexiconEO> lexiconEOS = dao.queryByList(null);
        int count = 0;
        int levelAll = 0;
        StringBuffer buffer = new StringBuffer(content);
        //遍历敏感词
        for (LexiconEO eo: lexiconEOS) {
            String word = eo.getWord();
            Integer level = eo.getLevel();
            int start = 0;
            int end = 0;
            //通过敏感词的首尾字符截取文章内容字符串
            while ((start = buffer.indexOf(String.valueOf(word.charAt(0)),end)) >= 0) {
                end = buffer.indexOf(String.valueOf(word.charAt(word.length()-1)),start);
                if (end < 0) {
                    break;
                }
                //截取文章内首尾同敏感词一样的字符串
                String str = buffer.substring(start, end+1);
                //去除字符串中间的空格
                str = str.replaceAll("&nbsp;","");
                //判断是否与敏感词一样
                if (str.equals(word)) {
                    if (type == 0) {
                        String spanStart;
                        //根据等级选择标记颜色
                        if (eo.getLevel() == 5) {
                            spanStart = "<span style=\"color: #FF0000;\">";
                        } else if (eo.getLevel() == 4 || eo.getLevel() == 3) {
                            spanStart = "<span style=\"color: #FFF500;\">";
                        } else {
                            spanStart = "<span style=\"color: #FF9500;\">";
                        }
                        String spanEnd = "</span>";
                        buffer.insert(start,spanStart);
                        buffer.insert(start+spanStart.length()+word.length(),spanEnd);
                        end += spanStart.length()+spanEnd.length();
                        count++;
                        levelAll += level;
                    } else {
                        String shie = "";
                        if (level == 5) {
                            for (int i = 0; i < word.length(); i++) {
                                shie += "*";
                            }
                        }
                        buffer.replace(start,end+1,shie);
                    }

                }
            }
        }
        double level = count == 0?0:levelAll/count;
        if (type == 0) {
            if (count >= 30 && level >= 3.8 || count >= 80 && level >= 3.0) {
                //等级一
                return "$del$" + buffer.toString();
            } else if (count <= 12 || level < 2.5) {
                //等级四
                return content;
            } else if (count < 20 && level < 3){
                //等级三
                return "$che$" + buffer.toString();
            } else {
                //登记二
                return "$aut$" + buffer.toString();
            }
        } else {
            if (count > 15 || level > 3.5) {
                return null;
            } else {
                return buffer.toString();
            }
        }
    }

//    public static void main(String[] args){
//        String str = "abcdcdfg";
//        StringBuffer buffer = new StringBuffer(str);
//        String s = "cd";
//
//        int start = 0;
//        int end = 0;
//        int count = 0;
//
//        while ((start = str.indexOf(s.charAt(0),end)) >= 0) {
//            end = str.indexOf(s.charAt(s.length()-1),start);
//            String n = str.substring(start, end+1);
//
//            String m = "__";
//            String b = "--";
//
//            if (n.equals(s)) {
//                buffer.insert(start+count*(m.length()+b.length()),m);
//
//                System.err.println(buffer);
//
//                buffer.insert(start+count*(m.length()+b.length())+m.length()+s.length(),b);
//
//                count++;
//
//                System.err.println(buffer);
//            }
//
//
//            end++;
//        }
//    }


}
