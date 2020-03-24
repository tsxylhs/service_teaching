package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Materials;
import com.teach.edu.core.entity.MaterialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialsMapper {
    long countByExample(MaterialsExample example);

    int deleteByExample(MaterialsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Materials record);

    int insertSelective(Materials record);

    List<Materials> selectByExample(MaterialsExample example);

    Materials selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Materials record, @Param("example") MaterialsExample example);

    int updateByExample(@Param("record") Materials record, @Param("example") MaterialsExample example);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);
}