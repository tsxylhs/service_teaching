package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Grade;
import com.teach.edu.core.entity.GradeExample;
import com.teach.edu.core.entity.Materials;
import com.teach.edu.core.entity.MaterialsExample;
import com.teach.edu.core.mapper.GradeMapper;
import com.teach.edu.core.mapper.MaterialsMapper;
import com.teach.edu.core.service.GradeService;
import com.teach.edu.core.service.MaterialsService;
import lombok.extern.log4j.Log4j2;
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
public class MaterialsServiceImp implements MaterialsService {
    @Autowired
    MaterialsMapper materialsMapper;


    @Override
    public Result list() {
        MaterialsExample ex=new MaterialsExample();
        MaterialsExample.Criteria c= ex.createCriteria();
        ex.setOrderByClause("created_at desc");
        List<Materials> Materialslist=materialsMapper.selectByExample(ex);
        return Result.ok(Materialslist);
    }

    @Override
    public Materials get(long id) {
        return materialsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Materials grade) {
        Date now=new Date();
        grade.setCreatedAt(now);
        grade.setUpdatedAt(now);


        return materialsMapper.insert(grade);
    }

    @Override
    public int update(Materials grade) {
        return materialsMapper.updateByPrimaryKey(grade);
    }

    @Override
    public int delete(long id) {
        return materialsMapper.deleteByPrimaryKey(id);
    }
}
