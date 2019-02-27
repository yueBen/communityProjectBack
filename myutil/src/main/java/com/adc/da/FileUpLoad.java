package com.adc.da;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    *
     * @param mtf 上传的文件
     * @param file  文件的保存路径
    * @return
    * @author yueben
    * date 2019-02-27
    **/
    public static String outFileUrl(MultipartFile mtf,File file) throws Exception{

        //判断存放文件的文件夹是否存在，不存在则创建一个
        if(!file.getParentFile().exists()) file.getParentFile().mkdir();

        String massage = MulFileToFile(mtf,file);

        if (massage == "ok"){
            String path = file.getAbsolutePath();
            System.err.println(path);

        }else{
            return massage;
        }
        return "";
    }
    
    /**  
    * 
     * @param mtf
     * @param path  
    * @return   
    * @author yueben
    * date 2019-02-27  
    **/
    public static String outFileUrl(MultipartFile mtf,String path){

        return "";
    }

    /**
    *
     * @param mtf
     * @param file
    * @return   将MultipartFile存放到本地
    * @author yueben
    * date 2019-02-27
    **/
    public static String MulFileToFile(MultipartFile mtf,File file) throws Exception{
        int b;
        byte[] bytes = new byte[1024];

        if (file.exists() && file.length() == 0) return "fileNull";

        if(mtf != null && !mtf.isEmpty()){
            InputStream is = mtf.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);

            while((b = is.read(bytes))!=-1){
                fos.write(bytes,0,b);
            }
            is.close();
            fos.close();
            return "ok";
        }else{
            return "null";
        }

    }

}
