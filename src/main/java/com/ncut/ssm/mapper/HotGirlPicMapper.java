package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.HotGirlPic;

public interface HotGirlPicMapper {
    int deleteByPrimaryKey(Integer hotgirlpicid);

    int insert(HotGirlPic record);

    int insertSelective(HotGirlPic record);

    HotGirlPic selectByPrimaryKey(Integer hotgirlpicid);

    int updateByPrimaryKeySelective(HotGirlPic record);

    int updateByPrimaryKey(HotGirlPic record);

    String selectByHotGirlGroupNum(int hotgirlgroupnum);
}