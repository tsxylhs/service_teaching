package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.service.HomeworkService;
import com.teach.edu.core.service.NotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @ClassName HomeWorkController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("homework")
@Api(value = "用于作业逻辑处理")
public class HomeWorkController {
    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(homeworkService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更新作业内容")
    @ApiImplicitParam(paramType = "update", name = "Homework", required = true, dataType = "homework")
    public Result update(@RequestBody Homework homework) {
        return Result.ok(homeworkService.update(homework));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取作业列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return homeworkService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新作业")
    public Result add(@RequestBody Homework homework) {

        homework.setId(new Random().nextLong());
        homeworkService.add(homework);
        return Result.ok();
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除作业")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result Delete(@PathVariable Long id) {
        return Result.ok(homeworkService.delete(id));
    }


}
