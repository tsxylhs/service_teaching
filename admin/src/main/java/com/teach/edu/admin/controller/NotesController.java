package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.admin.model.NoteVo;
import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.service.NotesService;
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
 * @ClassName NotesController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("notes")
@Api(value = "用于学习笔记的逻辑处理")
public class NotesController {
    @Autowired
    NotesService notesService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(notesService.get(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新笔记")
    @ApiImplicitParam(paramType = "update", name = "Notes", required = true, dataType = "notes")
    public Result update(@RequestBody Notes notes) {
        return Result.ok(notesService.update(notes));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取笔记列表")
    public Result userList(@RequestBody NoteVo noteVo) {
        return notesService.list(noteVo.userId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新的笔记")
    public Result add(@RequestBody Notes notes) {
        notes.setId(new Random().nextLong());
        notesService.add(notes);
        return Result.ok();
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除笔记")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result Delete(@PathVariable Long id) {
        return Result.ok(notesService.delete(id));
    }

}
