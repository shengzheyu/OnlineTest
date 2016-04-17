package com.ncut.ssm.service;

import com.ncut.ssm.pojo.Admin;

import com.ncut.ssm.pojo.HotGirlGroup;

import java.util.List;

/**
 * Created by ZY on 2016/4/11.
 */
public interface AdminService {
    public Admin getAdminByNum(String adminNum);

    public List<HotGirlGroup> getAllGroup();

    public int getAllGroupCount();

    public String selectByHotGirlGroupNum(int hotgirlgroupnum);

    public List<Admin> getAllAdmin();

    public HotGirlGroup getGroupNameByGroupNum(int groupnum);

    public void insertAdmin(Admin admin);

    public void deleteAdminByAdminNum(String adminNum);

    public int updateByPrimaryKeySelective(Admin admin);

    public Admin selectByPrimaryKey(Integer adminid);
}
