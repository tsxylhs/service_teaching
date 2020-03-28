package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Notes;

import java.util.List;

/**
 * @ClassName NotesService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface NotesService {
    List<Notes> getListByType(String type);

    Result list();

    Result list(Integer number);


    Result list(String type, Integer number);

    //材料列表
    Result list(String UserId);

    //往期活动回顾
    Result list(String id, PageRequest pageRequest);

    //根据id查询唯一对象
    Notes get(long id);

    //新增
    int add(Notes notes);

    //更新
    int update(Notes notes);

    //删除
    int delete(long id);

}
