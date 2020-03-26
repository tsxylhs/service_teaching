package com.teach.edu.admin.controller;

import com.teach.edu.admin.model.Info;
import com.teach.edu.core.entity.User;
import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.WxUser;
import com.teach.edu.core.service.HomeworkService;
import com.teach.edu.core.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.windbg.x86.WindbgX86ThreadFactory;


/**
 * @ClassName LoginController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 18-9-20
 **/
@RestController
@Log4j2
@Api(value = "用户登录验证")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    WxUserService wxUserService;


    @PostMapping("/")
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParam(paramType = "longinin")
    public Result login(@RequestBody User user) {

        return Result.ok();
    }

    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(paramType = "getUserInfo")
    public Result getInfo() {

        com.teach.edu.admin.model.Info info = new Info();
        info.name = "admin";
        info.avatar = "w";
         String [] str={"admin"};
        info.roles=str;
        return Result.ok(info);

    }

    @PutMapping("/")
    @ApiOperation(value = "用户登录信息")
    @ApiImplicitParam(paramType = "login", name = "User", required = true, dataType = "user")
    public Result update(@RequestBody User user) {
        return Result.ok();

    }

    @PostMapping("/xcx")
    @ApiOperation(value = "微信用户登录")
    @ApiImplicitParam(paramType = "weblodgin")
    public Result weblogin(@RequestBody WxUser wxUser) {
        log.info(wxUser.toString());
        wxUserService.CheckLogin(wxUser);
        return wxUserService.CheckLogin(wxUser);
    }

}
