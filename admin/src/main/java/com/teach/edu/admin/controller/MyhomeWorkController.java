package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.service.MyhomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MyhomeWorkController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("myhomework")
@Api(value = "用于我的作业逻辑处理")
public class MyhomeWorkController {
    @Autowired
    MyhomeworkService myhomeworkService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(myhomeworkService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更新我的作业内容")
    @ApiImplicitParam(paramType = "update", name = "Myhomework", required = true, dataType = "homework")
    public Result update(@RequestBody Myhomework homework) {
        return Result.ok(myhomeworkService.update(homework));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取我的作业列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return myhomeworkService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "完成上传我的作业")
    public Result add(@RequestBody Myhomework homework) {
        homework.setId(idGenerator.generateId().node());
        myhomeworkService.add(homework);
        return Result.ok();
    }
}
