package com.adc.da;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * //TODO 添加类/接口功能描述
 *文件上传工具类
 * @author yueben
 * @date 2019-02-27
 */
public class FileUpLoad {


    /**  
    * 生成项目根路径  
    * @return   
    * @author yueben  
    * 2019-03-13  
    **/
    public static String getPathRoot() throws Exception {
        String classPath = ResourceUtils.getURL("classpath:").getPath();
        String path = classPath.substring(0, classPath.indexOf("communityProjectBack") + 20);
        return path;
    }

    /**
    *
     * @param mtf 上传的文件
     * @param file  文件的保存路径
    * @return
    * @author yueben
    * date 2019-02-27
    **/
    public static String outFileUrl(MultipartFile mtf, File file) throws Exception {

        //判断存放文件的文件夹是否存在，不存在则创建一个
        if (!file.getParentFile().exists()) file.getParentFile().mkdir();

        String massage = MulFileToFile(mtf, file);

        if (massage.equals("ok")) {
            return massage;

        } else {
            return massage;
        }
    }

    /**
    *
     * @param mtf
     * @param file
    * @return   将MultipartFile存放到本地
    * @author yueben
    * date 2019-02-27
    **/
    public static String MulFileToFile(MultipartFile mtf, File file) throws Exception {
        int b;
        byte[] bytes = new byte[1024];

        if (file.exists() && file.length() == 0) return "fileNull";

        if (mtf != null && !mtf.isEmpty()) {
            InputStream is = mtf.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);

            while ((b = is.read(bytes)) != -1) {
                fos.write(bytes, 0, b);
            }
            is.close();
            fos.close();
            return "ok";
        } else {
            return "null";
        }

    }

    /**  
    * 
     * @param path  
    * @return   
    * @author yueben  
    * 2019-03-13  
    **/
    public static String photoToBase64(String path)throws Exception {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();
            BASE64Encoder encoder = new BASE64Encoder();
            return "data:images/gif;base64," + encoder.encode(bytes);
        } else {
            return null;
        }
    }

}
