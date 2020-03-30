package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.HomeworkExample;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.entity.MyhomeworkExample;
import com.teach.edu.core.mapper.HomeworkMapper;
import com.teach.edu.core.mapper.MyhomeworkMapper;
import com.teach.edu.core.service.HomeworkService;
import com.teach.edu.core.service.MyhomeworkService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MyhomeworkServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class HomeworkServiceImp implements HomeworkService {
    @Autowired
      HomeworkMapper homeworkMapper;


    @Override
    public Result list(PageRequest pageRequest) {
        HomeworkExample ex=new HomeworkExample();
        HomeworkExample.Criteria c= ex.createCriteria();
        if (!Strings.isEmpty(pageRequest.getConditions().get("className"))){
          String className= pageRequest.getConditions().get("className");
          c.andClassNameEqualTo(className);
        }
        ex.setOrderByClause("created_at desc");
        List<Homework> homeworklists=homeworkMapper.selectByExample(ex);
        return Result.ok(homeworklists);
    }

    @Override
    public Homework get(long id) {
        return homeworkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Homework homework) {
        Date now=new Date();
        homework.setCreatedAt(now);
        homework.setUpdatedAt(now);


        return homeworkMapper.insert(homework);
    }

    @Override
    public int update(Homework homework) {
        return homeworkMapper.updateByPrimaryKey(homework);
    }

    @Override
    public int delete(long id) {
        return homeworkMapper.deleteByPrimaryKey(id);
    }
}
