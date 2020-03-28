package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Grade;
import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.service.GradeService;
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
 * @ClassName GradeController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("grade")
@Api(value = "用于学习成绩的逻辑处理")
public class GradeController {
    @Autowired
    GradeService gradeService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(gradeService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更新学习成绩")
    @ApiImplicitParam(paramType = "update", name = "Grade", required = true, dataType = "grade")
    public Result update(@RequestBody Grade grade) {
        return Result.ok(gradeService.update(grade));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取学习成绩列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return gradeService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新的学习成绩")
    public Result add(@RequestBody Grade grade) {
        grade.setId(new Random().nextLong());
        gradeService.add(grade);
        return Result.ok();
    }
}
