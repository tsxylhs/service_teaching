package com.teach.edu.core.service.Imp;


import com.edu.common.code.model.Result;
import com.teach.edu.core.entity.Errormessage;
import com.teach.edu.core.entity.ErrormessageExample;
import com.teach.edu.core.mapper.ErrormessageMapper;
import com.teach.edu.core.service.ErrormessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MyerrormessageServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class ErrorMessageServiceImp implements ErrormessageService {
    @Autowired
     ErrormessageMapper errormessageMapper;



    @Override
    public Result list() {
        ErrormessageExample ex=new ErrormessageExample();
        ErrormessageExample.Criteria c= ex.createCriteria();
        ex.setOrderByClause("created_at desc");
        List<Errormessage> errormessagelists=errormessageMapper.selectByExample(ex);
        return Result.ok(errormessagelists);
    }

    @Override
    public Errormessage get(long id) {
        return errormessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Errormessage errormessage) {
        Date now=new Date();
        errormessage.setCreatedAt(now);
        errormessage.setUpdatedAt(now);

        return errormessageMapper.insert(errormessage);
    }

    @Override
    public int update(Errormessage errormessage) {
        return errormessageMapper.updateByPrimaryKey(errormessage);
    }

    @Override
    public int delete(long id) {
        return errormessageMapper.deleteByPrimaryKey(id);
    }
}
