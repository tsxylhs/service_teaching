package com.teach.edu.core.service.Imp;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Remind;
import com.teach.edu.core.entity.RemindExample;
import com.teach.edu.core.entity.Signin;
import com.teach.edu.core.entity.SigninExample;
import com.teach.edu.core.mapper.RemindMapper;
import com.teach.edu.core.mapper.SigninMapper;
import com.teach.edu.core.service.SigninService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SigninServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class SigninServiceImp implements SigninService {
    @Autowired
    SigninMapper signinMapper;



    @Override
    public Result list() {
        SigninExample example = new SigninExample();
        SigninExample.Criteria c = example.createCriteria();
        example.setOrderByClause("created_at desc");
        List<Signin> Signinlist = signinMapper.selectByExample(example);
        return Result.ok(Signinlist);
    }

    @Override
    public Signin get(long id) {
        return signinMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Signin notes) {

        Date now = new Date();
        notes.setCreatedAt(now);
        notes.setUpdatedAt(now);

        return signinMapper.insert(notes);
    }

    @Override
    public int update(Signin notes) {
        return signinMapper.updateByPrimaryKey(notes);
    }

    @Override
    public int delete(long id) {
        return signinMapper.deleteByPrimaryKey(id);
    }
}
