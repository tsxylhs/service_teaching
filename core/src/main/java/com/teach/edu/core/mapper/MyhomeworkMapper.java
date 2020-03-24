package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.entity.MyhomeworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyhomeworkMapper {
    long countByExample(MyhomeworkExample example);

    int deleteByExample(MyhomeworkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Myhomework record);

    int insertSelective(Myhomework record);

    List<Myhomework> selectByExample(MyhomeworkExample example);

    Myhomework selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Myhomework record, @Param("example") MyhomeworkExample example);

    int updateByExample(@Param("record") Myhomework record, @Param("example") MyhomeworkExample example);

    int updateByPrimaryKeySelective(Myhomework record);

    int updateByPrimaryKey(Myhomework record);
}