package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Tc;

public interface TcMapper {
    int deleteByPrimaryKey(Integer tcid);

    int insert(Tc record);

    int insertSelective(Tc record);

    Tc selectByPrimaryKey(Integer tcid);

    int updateByPrimaryKeySelective(Tc record);

    int updateByPrimaryKey(Tc record);
}