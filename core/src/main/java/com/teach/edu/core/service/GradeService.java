package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Grade;
import com.teach.edu.core.entity.Homework;

/**
 * @ClassName GradeService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface GradeService {
    Result list();
    //根据id查询唯一对象
    Grade get(long id);
    //新增
    int add(Grade grade);
    //更新
    int update(Grade grade);

    //删除
    int delete(long id);
}
