package com.teach.edu.core.service;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Materials;
import com.teach.edu.core.entity.Remind;

/**
 * @ClassName RemindService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
public interface RemindService {
    Result list(PageRequest pageRequest);
    //根据id查询唯一对象
    Remind get(long id);
    //新增
    int add(Remind remind);
    //更新
    int update(Remind remind);

    //删除
    int delete(long id);
}
