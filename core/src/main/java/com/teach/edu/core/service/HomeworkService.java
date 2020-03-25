package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Homework;

/**
 * @ClassName MyhomeworkService
 * @Author houlv
 * @Date 2020-03-24
 **/
public interface HomeworkService {

    Result list();
    //根据id查询唯一对象
    Homework get(long id);
    //新增
    int add(Homework homework);
    //更新
    int update(Homework homework);

    //删除
    int delete(long id);
}
