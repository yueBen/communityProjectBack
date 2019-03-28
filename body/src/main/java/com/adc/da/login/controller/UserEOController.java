package com.adc.da.login.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.login.entity.UserEO;
import com.adc.da.login.page.UserEOPage;
import com.adc.da.login.service.UserEOService;
import com.adc.da.personInfo.entity.PersonInfoEO;
import com.adc.da.personInfo.service.PersonInfoEOService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.utils.GsonUtil;
import com.adc.da.util.utils.ObjectUtils;
import com.adc.da.util.utils.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/${restPath}/login/user")
@Api(description = "|UserEO|")
public class UserEOController extends BaseController<UserEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserEOController.class);

    /**
     *      status: 0-待审批，1-审批通过，2-禁言，3-删除
     */

    @Autowired
    private UserEOService userEOService;

    @Autowired
    private PersonInfoEOService personInfoEOService;


    /**
     * 条件查询
     * @param page
     * @return
     * @author yueben
     * 2019-03-12
     **/
    @ApiOperation(value = "|UserEO|查询")
    @GetMapping("/queryList")
    @RequiresPermissions("login:user:page")
    public ResponseMessage<List<UserEO>> list(UserEOPage page) throws Exception {
        //要使用分页必须设置RowCount
        page.getPager().setRowCount(userEOService.queryByCount(page));
        return Result.success(userEOService.queryByList(page));
    }

    /**
     * 用户注册
     * @param userEO
     * @return
     * @author yueben
     * 2019-03-12
     **/
    @ApiOperation(value = "|UserEO|新增")
    @PostMapping("/add")
    @RequiresPermissions("login:user:save")
    public ResponseMessage create(@RequestBody UserEO userEO) throws Exception {
        userEO.setId(UUID.randomUserId());
        userEO.setCreateTime(new Date());
        userEO.setAccountLevel(3);
        userEO.setStatus(0);
        if (!userEOService.usernameCheck(userEO.getUserName())) {
            return Result.error("用户名重复!");
        }
        if (userEOService.insertSelective(userEO) == 1) {
            return Result.success("注册成功!");
        } else {
            return Result.error();
        }

    }

    /**
     * 禁言，密码重置，逻辑删除
     * @param userEO
     * @return
     * @author yueben
     * 2019-03-12
     **/
    @ApiOperation(value = "|UserEO|修改")
    @PostMapping("/update")
    @RequiresPermissions("login:user:update")
    public ResponseMessage<UserEO> update(@RequestBody UserEO userEO) throws Exception {
        userEOService.updateByPrimaryKeySelective(userEO);
        return Result.success(userEOService.selectByPrimaryKey(userEO.getId()));
    }

    /**
     * 登录
     * @param userEO
     * @return
     * @author yueben
     * 2019-03-12
     **/
    @ApiOperation(value = "|UserEO|登录")
    @PostMapping("/login")
    @RequiresPermissions("login:user:page")
    @ResponseBody
    public ResponseMessage<PersonInfoEO> userLogin(@RequestBody UserEO userEO) {
        UserEO user = userEOService.userLogin(userEO);
        try {
            if (user != null) {
                if (user.getStatus() == 0) {
                    return Result.error("等待管理员审核！");
                }
                if (user.getStatus() == 4) {
                    return Result.error("当前账户已失效！");
                }
                user.setOnlineTime(new Date());
                userEOService.updateByPrimaryKeySelective(user);
                PersonInfoEO person = personInfoEOService.getPersonByUid(user.getId());
                if (person == null) {
                    PersonInfoEO infoEO = new PersonInfoEO();
                    infoEO.setUId(user.getId());
                    return Result.success("001","请完善个人信息",infoEO);
                }
                long start = user.getCreateTime().getTime();
                long end = new Date().getTime();
                long format = (end-start)/(1000*24*60*60);
                person.setPhotoPath(""+format);
                return Result.success(person);
            } else {
                return Result.error("用户名或密码错误！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }
}
