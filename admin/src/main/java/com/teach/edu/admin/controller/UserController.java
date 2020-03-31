package com.teach.edu.admin.controller;

import com.teach.edu.core.entity.OmsUser;
import com.teach.edu.core.entity.User;
import com.teach.edu.core.service.OmsUserService;
import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 18-9-11
 **/
@RestController
@Log4j2
@RequestMapping("user")
@Api(value = "用于用户的curd")
public class UserController {
    @Autowired
    OmsUserService omsUserService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据用户ｉｄ查询用户信息")
    @ApiImplicitParam(paramType = "query" ,name = "id" ,value="用户id",required = true,dataType = "long")
    public Result get(@PathVariable Long id){
        return Result.ok(omsUserService.get(id));
    }
    @PutMapping("/")
    @ApiOperation(value="根据用户信息更改用户的属性")
    @ApiImplicitParam(paramType = "update",name="OmsUser",required = true,dataType = "user")
    public Result update(@RequestBody OmsUser user){
        return Result.ok(omsUserService.update(user));
    }
    @PostMapping("/list")
    @ApiOperation(value="查询用户的列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
      return omsUserService.list(pageRequest);
    }
    @PostMapping("/add")
    @ApiOperation(value="添加用户")
    public Result add(@RequestBody OmsUser user){
        omsUserService.add(user);
        return Result.ok();
    }


}
