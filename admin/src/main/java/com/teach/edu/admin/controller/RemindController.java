package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.entity.Remind;
import com.teach.edu.core.service.NotesService;
import com.teach.edu.core.service.RemindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @ClassName RemindController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("remind")
@Api(value = "用于提醒的逻辑处理")
public class RemindController {
    @Autowired
    RemindService remindService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(remindService.get(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新提醒")
    @ApiImplicitParam(paramType = "update", name = "Remind", required = true, dataType = "remind")
    public Result update(@RequestBody Remind remind) {
        return Result.ok(remindService.update(remind));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取提醒列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return remindService.list(pageRequest);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新的提醒")
    public Result add(@RequestBody Remind remind) {
        remind.setId(new Random().nextLong());
        remindService.add(remind);
        return Result.ok();
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除提醒")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result Delete(@PathVariable Long id) {
        return Result.ok(remindService.delete(id));
    }

}
