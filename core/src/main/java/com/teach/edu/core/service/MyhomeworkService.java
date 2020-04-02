package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.entity.Notes;

/**
 * @ClassName MyhomeworkService
 * @Author houlv
 * @Date 2020-03-24
 **/
public interface MyhomeworkService {

    Result list();
    //根据id查询唯一对象
    Myhomework get(long id);
    //新增
    int add(Myhomework myhomework);
    //更新
    int update(Myhomework myhomework);

    //删除
    int delete(long id);
    Myhomework getHomeworkId(long id);
}
