package com.adc.da.testWangEditor;

import com.adc.da.FileUpLoad;
import com.adc.da.test.controller.File_Form_Up;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


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
//    public ResponseMessage photoUpLoad(@RequestParam("22410")String files) throws Exception{
        //获取项目根目录
        String classPath = ResourceUtils.getURL("classpath:").getPath();
        String rootPath = classPath.substring(0, classPath.indexOf("communityProjectBack") + 20);
        String fileName = System.currentTimeMillis() + mtf.getOriginalFilename();

        File newFile = new File(rootPath + "/zzz/" + fileName);


        try {
            FileUpLoad.outFileUrl(mtf,newFile);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("error");
        }

        return Result.success("ok");
    }
}
