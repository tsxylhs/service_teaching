package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.entity.MyhomeworkExample;
import com.teach.edu.core.entityVo.MyhomeworkVo;
import com.teach.edu.core.mapper.MyhomeworkMapper;
import com.teach.edu.core.mapper.NotesMapper;
import com.teach.edu.core.service.MyhomeworkService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Override
    public Result list() {
        MyhomeworkExample ex=new MyhomeworkExample();
        MyhomeworkExample.Criteria c= ex.createCriteria();

        ex.setOrderByClause("created_at desc");
        List<Myhomework> myhomeworklists=myhomeworkMapper.selectByExample(ex);
        List<MyhomeworkVo>myhomeworkVolist =new ArrayList<>();
        for(int i=0;i<myhomeworklists.size();i++){

            MyhomeworkVo myhomeworkVo=new MyhomeworkVo();
            myhomeworkVo.myhomeworks=myhomeworklists.get(i);
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
        Date now=new Date();
        myhomework.setCreatedAt(now);
        myhomework.setUpdatedAt(now);


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
