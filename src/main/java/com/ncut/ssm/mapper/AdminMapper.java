package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin getAdminByNum(String adminNum);

    List<Admin> getAllAdmin();

    void deleteAdminByAdminNum(String adminNum);

}