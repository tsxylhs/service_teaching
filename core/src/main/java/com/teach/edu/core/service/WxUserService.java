package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Signin;
import com.teach.edu.core.entity.WxUser;

/**
 * @ClassName WxUserService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface WxUserService {
    Result list();
    //根据id查询唯一对象
    WxUser get(long id);
    //新增
    int add(WxUser wxUser);
    //更新
    WxUser update(WxUser wxUser);

    //删除
    int delete(long id);
  Result  CheckLogin(WxUser wxUser);
}
