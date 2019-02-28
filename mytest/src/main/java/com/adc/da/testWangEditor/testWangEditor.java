package com.adc.da.testWangEditor;

import com.adc.da.FileUpLoad;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;


/**
 * //TODO 添加类/接口功能描述
 *
 * @author yueben
 * @date 2019-02-27
 */
@RestController
@RequestMapping("/${restPath}/wangEditorPhoto")
@Api(description = "|WangEditor|")
public class testWangEditor {

    /**
     * @return
     * @author yueben
     * date 2019-02-27
     **/
    @RequestMapping("/test")
    @ResponseBody
    public ResponseMessage photoUpLoad(@RequestParam("22410") MultipartFile mtf) throws Exception {
        //获取项目根目录
        String classPath = ResourceUtils.getURL("classpath:").getPath();
        String rootPath = classPath.substring(0, classPath.indexOf("communityProjectBack") + 20);
        String fileName = System.currentTimeMillis() + mtf.getOriginalFilename();

        File newFile = new File(rootPath + "/mytest/src/main/resources/static/img/" + fileName);


        try {
            if (FileUpLoad.outFileUrl(mtf, newFile).equals("ok")) {
                FileInputStream fis = new FileInputStream(newFile);
                byte[] bytes = new byte[fis.available()];

                System.err.println("------fileupload---------" + fis.read(bytes));

                fis.close();

                BASE64Encoder encoder = new BASE64Encoder();
                return Result.success("data:images/gif;base64," + encoder.encode(bytes));
            } else {
                return Result.error("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("error");
        }
    }
}
