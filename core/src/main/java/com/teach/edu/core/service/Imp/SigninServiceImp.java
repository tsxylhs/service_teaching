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
        List<Signin> Signinlist = signinMapper.selectByExample(example);
        return Result.ok(Signinlist);
    }

    @Override
    public Signin get(long id) {
        return signinMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result add(Signin signin) {

        Date now = new Date();
        signin.setCreatedAt(now);
        signin.setUpdatedAt(now);
        signinMapper.insert(signin);
        return Result.ok(signin);
    }

    @Override
    public int update(Signin signin) {
        return signinMapper.updateByPrimaryKey(signin);
    }

    @Override
    public int delete(long id) {
        return signinMapper.deleteByPrimaryKey(id);
    }
}
