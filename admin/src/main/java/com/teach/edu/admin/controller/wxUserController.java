package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.WxUser;
import com.teach.edu.core.service.WxUserService;
import com.teach.edu.core.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @ClassName HomeWorkController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("wxUser")
@Api(value = "用于微信学生用户")
public class wxUserController {
    @Autowired
    WxUserService wxUserService;
    @PostMapping("/list")
    @ApiOperation(value = "获取学生列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return wxUserService.list();
    }


}
