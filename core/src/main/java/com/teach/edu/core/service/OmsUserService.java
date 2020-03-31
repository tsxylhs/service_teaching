package com.teach.edu.core.service;

import com.teach.edu.core.entity.OmsUser;
import com.teach.edu.core.entity.Signin;
import com.teach.edu.core.entity.User;
import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;

import java.util.List;


/**
 * @ClassName OmsUserService
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 18-9-11
 **/
public interface OmsUserService {
     Result list(PageRequest pageRequest);
     OmsUser get(Long id);
     int update(OmsUser user);
     int add(OmsUser user);
     OmsUser login(OmsUser user);
}

