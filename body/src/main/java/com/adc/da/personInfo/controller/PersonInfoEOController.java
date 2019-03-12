package com.adc.da.personInfo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.adc.da.FileUpLoad;
import com.adc.da.util.utils.DateUtils;
import com.adc.da.util.utils.ObjectUtils;
import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.personInfo.entity.PersonInfoEO;
import com.adc.da.personInfo.page.PersonInfoEOPage;
import com.adc.da.personInfo.service.PersonInfoEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/${restPath}/personInfo/personInfo")
@Api(description = "|PersonInfoEO|")
public class PersonInfoEOController extends BaseController<PersonInfoEO>{

    private static final Logger logger = LoggerFactory.getLogger(PersonInfoEOController.class);

    @Autowired
    private PersonInfoEOService personInfoEOService;

    @ApiOperation(value = "|PersonInfoEO|个人信息新增修改")
    @PostMapping("/add")
    @RequiresPermissions("personInfo:personInfo:save")
    public ResponseMessage create(String id, String uid, String name, String phone, String birthday, String address,
                                  String gender, String introduce, MultipartFile photo) throws Exception {

        PersonInfoEOPage page = new PersonInfoEOPage();
        page.setUId(uid);
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

        if (personInfoEOService.queryByList(page).size() == 0) {
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

	@ApiOperation(value = "|PersonInfoEO|查询")
    @GetMapping("")
    @RequiresPermissions("personInfo:personInfo:list")
    public ResponseMessage<List<PersonInfoEO>> list(PersonInfoEOPage page) throws Exception {
        return Result.success(personInfoEOService.queryByList(page));
	}

    @ApiOperation(value = "|PersonInfoEO|详情")
    @GetMapping("/{id}")
    @RequiresPermissions("personInfo:personInfo:get")
    public ResponseMessage<PersonInfoEO> find(@PathVariable String id) throws Exception {
        return Result.success(personInfoEOService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "|PersonInfoEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("personInfo:personInfo:update")
    public ResponseMessage<PersonInfoEO> update(@RequestBody PersonInfoEO personInfoEO) throws Exception {
        personInfoEOService.updateByPrimaryKeySelective(personInfoEO);
        return Result.success(personInfoEO);
    }

    @ApiOperation(value = "|PersonInfoEO|删除")
    @DeleteMapping("/{id}")
    @RequiresPermissions("personInfo:personInfo:delete")
    public ResponseMessage delete(@PathVariable String id) throws Exception {
        personInfoEOService.deleteByPrimaryKey(id);
        logger.info("delete from person_info where id = {}", id);
        return Result.success();
    }

}
