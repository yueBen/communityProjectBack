package com.adc.da.personInfo.controller;

import com.adc.da.FileDownLoad;
import com.adc.da.FileUpLoad;
import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.PersonInfoEO;
import com.adc.da.personInfo.service.PersonInfoEOService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.DateUtils;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/${restPath}/personInfo/personInfo")
@Api(description = "|PersonInfoEO|")
public class PersonInfoEOController extends BaseController<PersonInfoEO>{

    private static final Logger logger = LoggerFactory.getLogger(PersonInfoEOController.class);

    @Autowired
    private PersonInfoEOService personInfoEOService;

    /**
    * 用戶個人信息修改新增
     * @param id
     * @param uid
     * @param name
     * @param phone
     * @param birthday
     * @param address
     * @param gender
     * @param introduce
     * @param photo
    * @return
    * @author yueben
    * 2019-03-13
    **/
    @ApiOperation(value = "|PersonInfoEO|个人信息新增修改")
    @PostMapping("/add")
    @RequiresPermissions("personInfo:personInfo:save")
    public ResponseMessage create(String id, String uid, String name, String phone, String birthday, String address,
                                  String gender, String introduce, MultipartFile photo) throws Exception {

        PersonInfoEO personInfoEO = new PersonInfoEO();
        personInfoEO.setUId(uid);
        personInfoEO.setName(name);
        personInfoEO.setPhone(phone);
        personInfoEO.setBirthday(DateUtils.stringToDate(birthday, "yyyy-MM-dd"));
        personInfoEO.setAddress(address);
        personInfoEO.setGender(gender);
        personInfoEO.setIntroduce(introduce);

        if (photo != null && !photo.isEmpty()) {
            String path = saveUserPhoto(photo, FileUpLoad.getPathRoot() + "/userPhoto");
            if (path == null) {
                return Result.error("头像上传失败");
            }
            personInfoEO.setPhotoPath(path);
        }

        if (personInfoEOService.getPersonByUid(uid) == null) {
            personInfoEO.setId(UUID.randomUUID());
            personInfoEOService.insertSelective(personInfoEO);
            return Result.success("新增成功");
        } else {
            personInfoEO.setId(id);
            personInfoEOService.updateByPrimaryKeySelective(personInfoEO);
            return Result.success("修改成功");
        }
    }
    
    /**  
    * 用户头像保存
     * @param mft
     * @param path  
    * @return   
    * @author yueben  
    * 2019-03-12  
    **/
    private String saveUserPhoto(MultipartFile mft, String path) throws Exception {
        File file = new File(path + "/" + mft.getOriginalFilename());
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (FileUpLoad.MulFileToFile(mft, file).equals("ok")) {
            return file.getPath();
        } else {
            return null;
        }
    }

    /**
    * 根据uid查询个人信息
     * @param uid
    * @return
    * @author yueben
    * 2019-03-13
    **/
    @ApiOperation(value = "|PersonInfoEO|详情")
    @GetMapping("/{uid}")
    @RequiresPermissions("personInfo:personInfo:get")
    public ResponseMessage<PersonInfoEO> find(@PathVariable String uid) {
        PersonInfoEO eo = personInfoEOService.getPersonByUid(uid);
        if (eo != null) {
            return Result.success(eo);
        } else {
            return null;
        }
    }

    @ApiOperation(value = "|PersonInfoEO|头像显示")
    @GetMapping("/{uid}/down")
    @RequiresPermissions("personInfo:personInfo:get")
    public void photoPath(@PathVariable String uid, HttpServletResponse response) {

        PersonInfoEO eo = personInfoEOService.getPersonByUid(uid);
        if (eo != null) {
            File file = new File(eo.getPhotoPath());

            if (file.exists()) {
                try {
                    FileDownLoad.fileResponseDown(response, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
