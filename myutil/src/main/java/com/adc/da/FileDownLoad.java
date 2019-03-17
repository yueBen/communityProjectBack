package com.adc.da;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 文件下载
 *
 * @author yueben
 * @date 2019-03-13
 */
public class FileDownLoad {

    public static void fileResponseDown(HttpServletResponse response, File file)throws Exception {
        //清除响应缓存信息
        response.reset();
        response.setHeader("Content-Disposition", "inline; filename=" + new String(file.getName().getBytes(),"utf-8"));
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.indexOf('.') + 1, fileName.length());
        response.setContentType("image/" + suffix);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        bos.flush();
        bos.close();
        bis.close();
    }

}
