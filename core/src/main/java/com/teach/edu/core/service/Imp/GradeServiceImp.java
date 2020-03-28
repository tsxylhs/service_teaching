package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Grade;
import com.teach.edu.core.entity.GradeExample;
import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.HomeworkExample;
import com.teach.edu.core.mapper.GradeMapper;
import com.teach.edu.core.mapper.HomeworkMapper;
import com.teach.edu.core.service.GradeService;
import com.teach.edu.core.service.HomeworkService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import sun.jvm.hotspot.debugger.Page;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MyhomeworkServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class GradeServiceImp implements GradeService {
    @Autowired
    GradeMapper gradeMapper;


    @Override
    public Result list(PageRequest pageRequest) {
        GradeExample ex=new GradeExample();
        GradeExample.Criteria c= ex.createCriteria();
        if (!Strings.isEmpty(pageRequest.getConditions().get("userId"))){
            String studentId=pageRequest.getConditions().get("userId");
            c.andStudentIdEqualTo(Long.parseLong(studentId));
        }
        ex.setOrderByClause("created_at desc");
        List<Grade> gradelists=gradeMapper.selectByExample(ex);
        return Result.ok(gradelists);
    }

    @Override
    public Grade get(long id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Grade grade) {
        Date now=new Date();
        grade.setCreatedAt(now);
        grade.setUpdatedAt(now);


        return gradeMapper.insert(grade);
    }

    @Override
    public int update(Grade grade) {
        return gradeMapper.updateByPrimaryKey(grade);
    }

    @Override
    public int delete(long id) {
        return gradeMapper.deleteByPrimaryKey(id);
    }
}
