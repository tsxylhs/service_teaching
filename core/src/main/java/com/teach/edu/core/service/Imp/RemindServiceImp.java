package com.teach.edu.core.service.Imp;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;

import com.teach.edu.core.entity.Remind;
import com.teach.edu.core.entity.RemindExample;

import com.teach.edu.core.mapper.RemindMapper;
import com.teach.edu.core.service.RemindService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName RemindServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class RemindServiceImp implements RemindService {
    @Autowired
    RemindMapper remindMapper;





    @Override
    public Result list() {
        RemindExample example = new RemindExample();
        RemindExample.Criteria c = example.createCriteria();
        example.setOrderByClause("created_at desc");
        List<Remind> Remindlist = remindMapper.selectByExample(example);
        return Result.ok(Remindlist);
    }

    @Override
    public Remind get(long id) {
        return remindMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Remind notes) {

        Date now = new Date();
        notes.setCreatedAt(now);
        notes.setUpdatedAt(now);

        return remindMapper.insert(notes);
    }

    @Override
    public int update(Remind notes) {
        return remindMapper.updateByPrimaryKey(notes);
    }

    @Override
    public int delete(long id) {
        return remindMapper.deleteByPrimaryKey(id);
    }
}
