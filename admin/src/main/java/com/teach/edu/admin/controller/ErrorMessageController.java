package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Errormessage;
import com.teach.edu.core.entity.User;
import com.teach.edu.core.service.ErrormessageService;
import com.teach.edu.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ErrorMessageController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("errormessage")
@Api(value = "用于错误信息的curd")
public class ErrorMessageController {
    @Autowired
    ErrormessageService errormessageService;

    IdGenerator idGenerator;
    @GetMapping("/{id}")
    @ApiOperation(value = "根据错误Id信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(errormessageService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更改错误信息")
    @ApiImplicitParam(paramType = "update", name = "Errormessage", required = true, dataType = "errormessage")
    public Result update(@RequestBody Errormessage errormessage) {
        return Result.ok(errormessageService.update(errormessage));
    }

    @PostMapping("/list")
    @ApiOperation(value = "错误信息列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return errormessageService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加错误信息")
    public Result add(@RequestBody Errormessage errormessage) {
        errormessage.setId(idGenerator.generateId().node());
        errormessageService.add(errormessage);
        return Result.ok();
    }
}
