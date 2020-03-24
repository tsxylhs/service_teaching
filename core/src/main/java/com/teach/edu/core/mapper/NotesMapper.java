package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.Notes;
import com.teach.edu.core.entity.NotesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesMapper {
    long countByExample(NotesExample example);

    int deleteByExample(NotesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Notes record);

    int insertSelective(Notes record);

    List<Notes> selectByExample(NotesExample example);

    Notes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Notes record, @Param("example") NotesExample example);

    int updateByExample(@Param("record") Notes record, @Param("example") NotesExample example);

    int updateByPrimaryKeySelective(Notes record);

    int updateByPrimaryKey(Notes record);
}