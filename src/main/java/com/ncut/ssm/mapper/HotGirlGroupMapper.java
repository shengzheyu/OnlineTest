package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.HotGirlGroup;

import java.util.List;

public interface HotGirlGroupMapper {
    int deleteByPrimaryKey(Integer hotgirlid);

    int insert(HotGirlGroup record);

    int insertSelective(HotGirlGroup record);

    HotGirlGroup selectByPrimaryKey(Integer hotgirlid);

    int updateByPrimaryKeySelective(HotGirlGroup record);

    int updateByPrimaryKey(HotGirlGroup record);

    List<HotGirlGroup> getAllGroup();

    int getAllGroupCount();

    HotGirlGroup getGroupNameByGroupNum(int groupnum);
}