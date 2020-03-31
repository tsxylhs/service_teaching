package com.teach.edu.core.service.Imp;

import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.*;
import com.teach.edu.core.mapper.GradeMapper;
import com.teach.edu.core.mapper.RemindMapper;
import com.teach.edu.core.mapper.SigninMapper;
import com.teach.edu.core.mapper.WxUserMapper;
import com.teach.edu.core.service.SigninService;
import com.teach.edu.core.service.WxUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    WxUserMapper wxUserMapper;
    @Autowired
    GradeMapper gradeMapper;


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
        WxUserExample wx = new WxUserExample();
        WxUserExample.Criteria wxc = wx.createCriteria();
        wxc.andStudentIdEqualTo(signin.getStudentId().toString());
        List<WxUser> wxUsers = wxUserMapper.selectByExample(wx);
        //利用用户学号和课程查询成绩
        GradeExample gex = new GradeExample();
        GradeExample.Criteria c = gex.createCriteria();
        c.andStudentIdEqualTo(Long.parseLong(wxUsers.get(0).getStudentId())).andClassNameEqualTo(signin.getClassName());
        List<Grade> grades = gradeMapper.selectByExample(gex);
        if (grades.size() > 0) {
            //加入平时表现成绩
            if(!grades.get(0).getSignin().equals(null)) {
                grades.get(0).setSignin(grades.get(0).getSignin() + 4);
            }else{
                grades.get(0).setSignin(4.0);
            }
            //加入总成绩
            if (!grades.get(0).getGrades().equals(null)) {
                grades.get(0).setGrades(grades.get(0).getGrades() + 4 * 0.7);
            }else{
                grades.get(0).setGrades(4.0*0.7);
            }
            //跟新总成成绩
            gradeMapper.updateByPrimaryKey(grades.get(0));
        } else {
            Grade grade = new Grade();
            grade.setId(new Random().nextLong());
            grade.setCreatedAt(new Date());
            grade.setUpdatedAt(new Date());
            grade.setClassName(wxUsers.get(0).getClassName());
            grade.setSignin(4.0);
            grade.setCourseGrade(2);
            grade.setGrades(4 * 0.7);
            grade.setCourseName(signin.getCrouseName());
            grade.setTeachName(signin.getTeachName());
            gradeMapper.insert(grade);
        }
        return signinMapper.updateByPrimaryKey(signin);
    }

    @Override
    public int delete(long id) {
        return signinMapper.deleteByPrimaryKey(id);
    }
}
