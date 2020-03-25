package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Grade;
import com.teach.edu.core.entity.Materials;

/**
 * @ClassName MaterialsService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface MaterialsService {
    Result list();
    //根据id查询唯一对象
    Materials get(long id);
    //新增
    int add(Materials materials);
    //更新
    int update(Materials materials);

    //删除
    int delete(long id);
}
