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

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(wxUserService.get(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新学生信息")
    @ApiImplicitParam(paramType = "update", name = "WxUser", required = true, dataType = "wxUser")
    public Result update(@RequestBody WxUser wxUser) {
        return Result.ok(wxUserService.update(wxUser));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取学生列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return wxUserService.list();
    }


}
