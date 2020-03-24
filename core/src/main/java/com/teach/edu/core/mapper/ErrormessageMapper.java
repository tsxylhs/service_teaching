package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Errormessage;
import com.teach.edu.core.entity.ErrormessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrormessageMapper {
    long countByExample(ErrormessageExample example);

    int deleteByExample(ErrormessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Errormessage record);

    int insertSelective(Errormessage record);

    List<Errormessage> selectByExample(ErrormessageExample example);

    Errormessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Errormessage record, @Param("example") ErrormessageExample example);

    int updateByExample(@Param("record") Errormessage record, @Param("example") ErrormessageExample example);

    int updateByPrimaryKeySelective(Errormessage record);

    int updateByPrimaryKey(Errormessage record);
}