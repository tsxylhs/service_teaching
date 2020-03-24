package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Remind;
import com.teach.edu.core.entity.RemindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemindMapper {
    long countByExample(RemindExample example);

    int deleteByExample(RemindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Remind record);

    int insertSelective(Remind record);

    List<Remind> selectByExample(RemindExample example);

    Remind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByExample(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByPrimaryKeySelective(Remind record);

    int updateByPrimaryKey(Remind record);
}