package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Signin;
import com.teach.edu.core.service.SigninService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SigninController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-25
 **/
@RestController
@Log4j2
@RequestMapping("signin")
@Api(value = "用于学习签到的逻辑处理")
public class SigninController {
    @Autowired
    SigninService signinService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(signinService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更新学习签到")
    @ApiImplicitParam(paramType = "update", name = "Signin", required = true, dataType = "signin")
    public Result update(@RequestBody Signin signin) {
        return Result.ok(signinService.update(signin));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取学习签到列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return signinService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新的学习签到")
    public Result add(@RequestBody Signin signin) {
        signin.setId(idGenerator.generateId().node());
        signinService.add(signin);
        return Result.ok();
    }
}
