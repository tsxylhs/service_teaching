package com.teach.edu.core.service.Imp;

import com.edu.common.code.model.Result;

import com.teach.edu.core.entity.WxUser;
import com.teach.edu.core.entity.WxUserExample;
import com.teach.edu.core.mapper.WxUserMapper;
import com.teach.edu.core.service.WxUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName WxUserServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class WxUserServiceImp implements WxUserService {
    @Autowired
    WxUserMapper wxUserMapper;




    @Override
    public Result list() {
        WxUserExample example = new WxUserExample();
        WxUserExample.Criteria c = example.createCriteria();
        example.setOrderByClause("created_at desc");
        List<WxUser> WxUserlist = wxUserMapper.selectByExample(example);
        return Result.ok(WxUserlist);
    }

    @Override
    public WxUser get(long id) {
        return wxUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(WxUser notes) {
        Date now = new Date();
        notes.setCreatedAt(now);
        notes.setUpdatedAt(now);

        return wxUserMapper.insert(notes);
    }

    @Override
    public int update(WxUser notes) {
        return wxUserMapper.updateByPrimaryKey(notes);
    }

    @Override
    public int delete(long id) {
        return wxUserMapper.deleteByPrimaryKey(id);
    }
}
