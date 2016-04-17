package com.ncut.ssm.service.serviceImpl;

import com.ncut.ssm.mapper.AdminMapper;
import com.ncut.ssm.mapper.HotGirlGroupMapper;
import com.ncut.ssm.mapper.HotGirlPicMapper;
import com.ncut.ssm.pojo.Admin;
import com.ncut.ssm.pojo.HotGirlGroup;
import com.ncut.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZY on 2016/4/11.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper AdminDao;
    @Autowired
    private HotGirlGroupMapper HotGirlGroupDao;
    @Autowired
    private HotGirlPicMapper HotGirlPicDao;


    public Admin getAdminByNum(String adminNum){
        return this.AdminDao.getAdminByNum(adminNum);
    }

    public List<Admin> getAllAdmin(){
        return this.AdminDao.getAllAdmin();
    }

    public HotGirlGroup getGroupNameByGroupNum(int groupnum){
        return this.HotGirlGroupDao.getGroupNameByGroupNum(groupnum);
    }

    public List<HotGirlGroup> getAllGroup(){
        return this.HotGirlGroupDao.getAllGroup();
    }

    public int getAllGroupCount(){
        return this.HotGirlGroupDao.getAllGroupCount();
    }

    public String selectByHotGirlGroupNum(int hotgirlgroupnum){
        return this.HotGirlPicDao.selectByHotGirlGroupNum(hotgirlgroupnum);
    }

    public void insertAdmin(Admin admin){
       this.AdminDao.insertSelective(admin);
    }

    //根据adminNum删除admin
    public void deleteAdminByAdminNum(String adminNum){
        this.AdminDao.deleteAdminByAdminNum(adminNum);
    }
    
    //逆向工程 生成的更新xml,根据传入对象的adminNum 进行整体更新
    public int updateByPrimaryKeySelective(Admin admin){
        this.AdminDao.updateByPrimaryKeySelective(admin);
        return 0;
    }

    public Admin selectByPrimaryKey(Integer adminid){
        return this.AdminDao.selectByPrimaryKey(adminid);
    }
}
