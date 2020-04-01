package com.teach.edu.core.mapper;

import com.teach.edu.core.entity.OmsUser;
import com.teach.edu.core.entity.OmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsUserMapper {
    long countByExample(OmsUserExample example);

    int deleteByExample(OmsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsUser record);

    int insertSelective(OmsUser record);

    List<OmsUser> selectByExample(OmsUserExample example);

    OmsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsUser record, @Param("example") OmsUserExample example);

    int updateByExample(@Param("record") OmsUser record, @Param("example") OmsUserExample example);

    int updateByPrimaryKeySelective(OmsUser record);

    int updateByPrimaryKey(OmsUser record);
}