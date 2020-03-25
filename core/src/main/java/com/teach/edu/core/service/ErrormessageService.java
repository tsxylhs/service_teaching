package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Errormessage;
import com.teach.edu.core.entity.Homework;

/**
 * @ClassName MyhomeworkService
 * @Author houlv
 * @Date 2020-03-24
 **/
public interface ErrormessageService {

    Result list();
    //根据id查询唯一对象
    Errormessage get(long id);
    //新增
    int add(Errormessage errormessage);
    //更新
    int update(Errormessage errormessage);

    //删除
    int delete(long id);
}
