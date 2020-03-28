package com.teach.edu.core.service.Imp;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.entity.NotesExample;
import com.teach.edu.core.mapper.NotesMapper;
import com.teach.edu.core.service.NotesService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName NotesServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class NotesServiceImp implements NotesService {
    @Autowired
    NotesMapper notesMapper;



    @Override
    public List<Notes> getListByType(String type) {
        return null;
    }

    @Override
    public Result list() {
        return null;
    }

    @Override
    public Result list(Integer number) {
        NotesExample example = new NotesExample();
        NotesExample.Criteria c = example.createCriteria();
        example.setOrderByClause("created_at desc");
        List<Notes> noteslist = notesMapper.selectByExample(example);
        return Result.ok(noteslist);
    }


    @Override
    public Result list(String type, Integer number) {
        return null;
    }

    @Override
    public Result list(String userId) {
           NotesExample ex=new NotesExample();
           NotesExample.Criteria c=ex.createCriteria();
           c.andUserIdEqualTo(Long.parseLong(userId));
           List<Notes> noteslist = notesMapper.selectByExample(ex);
           return Result.ok(noteslist);
    }

    @Override
    public Result list(String id, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Notes get(long id) {
        return notesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Notes notes) {
        Date now = new Date();
        notes.setCreatedAt(now);
        notes.setUpdatedAt(now);

        return notesMapper.insert(notes);
    }

    @Override
    public int update(Notes notes) {
        return notesMapper.updateByPrimaryKey(notes);
    }

    @Override
    public int delete(long id) {
        return notesMapper.deleteByPrimaryKey(id);
    }
}
