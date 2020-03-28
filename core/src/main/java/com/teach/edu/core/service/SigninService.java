package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Remind;
import com.teach.edu.core.entity.Signin;

/**
 * @ClassName SigninService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface SigninService {
    Result list();
    //根据id查询唯一对象
    Signin get(long id);
    //新增
    Result add(Signin signin);
    //更新
    int update(Signin signin);

    //删除
    int delete(long id);
}
