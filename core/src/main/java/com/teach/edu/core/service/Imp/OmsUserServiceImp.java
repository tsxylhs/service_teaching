package com.teach.edu.core.service.Imp;

import com.teach.edu.core.entity.*;
import com.teach.edu.core.mapper.OmsUserMapper;
import com.teach.edu.core.service.OmsUserService;
import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageData;
import com.edu.common.code.page.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;


import java.util.Date;
import java.util.List;

/**
 * @ClassName OmsUserServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 18-9-11
 **/
@Log4j2
@Service
public class OmsUserServiceImp implements OmsUserService {
    @Autowired
    OmsUserMapper omsuserMapper;

    @Override
    public OmsUser get(Long id) {
        return omsuserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(OmsUser user) {
        return omsuserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Result list(PageRequest pageRequest) {
        PageHelper.offsetPage(pageRequest.getStart(), pageRequest.getOffset(), true);
        OmsUserExample ex = new OmsUserExample();
        OmsUserExample.Criteria c = ex.createCriteria();
        List<OmsUser> users = omsuserMapper.selectByExample(ex);
        return Result.ok(
                new PageData(new PageInfo<>(users).getTotal(), pageRequest.getPage(), pageRequest.getPageSize()),
                users);
    }

    @Override
    public int add(OmsUser user) {
        return omsuserMapper.insert(user);
    }

    @Override
    public OmsUser login(OmsUser user) {
        OmsUserExample ex = new OmsUserExample();
        OmsUserExample.Criteria c = ex.createCriteria();
        c.andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
        List<OmsUser> u = omsuserMapper.selectByExample(ex);
        if (u.size() > 0) {
            return user;
        } else {
            return null;
        }
    }
}
