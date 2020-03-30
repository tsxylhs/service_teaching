package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.*;
import com.teach.edu.core.entityVo.MyhomeworkVo;
import com.teach.edu.core.mapper.*;
import com.teach.edu.core.service.MyhomeworkService;
import io.swagger.annotations.Authorization;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @ClassName MyhomeworkServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class MyhomeworkServiceImp implements MyhomeworkService {
    @Autowired
    MyhomeworkMapper myhomeworkMapper;
    @Autowired
    HomeworkMapper homeworkMapper;
    @Autowired
    WxUserMapper wxUserMapper;
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Result list() {
        MyhomeworkExample ex = new MyhomeworkExample();
        MyhomeworkExample.Criteria c = ex.createCriteria();

        ex.setOrderByClause("created_at desc");
        List<Myhomework> myhomeworklists = myhomeworkMapper.selectByExample(ex);
        List<MyhomeworkVo> myhomeworkVolist = new ArrayList<>();
        for (int i = 0; i < myhomeworklists.size(); i++) {

            MyhomeworkVo myhomeworkVo = new MyhomeworkVo();
            myhomeworkVo.myhomeworks = myhomeworklists.get(i);
            //查询user
            //查询作业
        }
        return Result.ok(myhomeworklists);
    }

    @Override
    public Myhomework get(long id) {
        return myhomeworkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Myhomework myhomework) {
        Date now = new Date();
        myhomework.setCreatedAt(now);
        myhomework.setUpdatedAt(now);

        Homework homework = homeworkMapper.selectByPrimaryKey(myhomework.getHomeworkId());
        //将homework的提交记录同步到成绩

        //获取用户信息
        WxUser wxUser = wxUserMapper.selectByPrimaryKey(myhomework.getUserId());
        //利用用户学号和课程查询成绩
        GradeExample gex = new GradeExample();
        GradeExample.Criteria c = gex.createCriteria();
        c.andStudentIdEqualTo(Long.parseLong(wxUser.getStudentId())).andClassNameEqualTo(homework.getClassName());
        List<Grade> grades = gradeMapper.selectByExample(gex);
          if (grades.size()>0){
              //加入平时表现成绩
            grades.get(0).setShowGrades(grades.get(0).getShowGrades()+4);
            //加入总成绩
            grades.get(0).setGrades(grades.get(0).getGrades()+4*0.7);
            //跟新总成成绩
            gradeMapper.updateByPrimaryKey(grades.get(0));
          }else{
              Grade grade=new Grade();
              grade.setId(new Random().nextLong());
              grade.setCreatedAt(new Date());
              grade.setUpdatedAt(new Date());
              grade.setClassName(wxUser.getClassName());
              grade.setShowGrades(4.0);
              grade.setCourseGrade(2);
              grade.setGrades(4*0.7);
              grade.setCourseName(homework.getCourseName());
              grade.setTeachName(homework.getTeachName());
              gradeMapper.insert(grade);
          }
        return myhomeworkMapper.insert(myhomework);
    }

    @Override
    public int update(Myhomework myhomework) {
        return myhomeworkMapper.updateByPrimaryKey(myhomework);
    }

    @Override
    public int delete(long id) {
        return myhomeworkMapper.deleteByPrimaryKey(id);
    }
}
