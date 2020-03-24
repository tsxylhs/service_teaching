package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.HomeworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeworkMapper {
    long countByExample(HomeworkExample example);

    int deleteByExample(HomeworkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Homework record);

    int insertSelective(Homework record);

    List<Homework> selectByExample(HomeworkExample example);

    Homework selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Homework record, @Param("example") HomeworkExample example);

    int updateByExample(@Param("record") Homework record, @Param("example") HomeworkExample example);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);
}