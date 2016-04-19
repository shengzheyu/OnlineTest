package com.ncut.ssm.service.serviceImpl;

import com.ncut.ssm.mapper.TcMapper;
import com.ncut.ssm.mapper.TeacherMapper;
import com.ncut.ssm.pojo.Tc;
import com.ncut.ssm.pojo.Teacher;
import com.ncut.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cqq on 2016/4/17.
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper teacherDao;
    @Autowired
    private TcMapper tcDao;

    public Teacher selectByPrimaryKey(Integer teacherid){
        return this.teacherDao.selectByPrimaryKey(teacherid);
    }

    public int updateByPrimaryKeySelective(Teacher teacher){
        this.teacherDao.updateByPrimaryKeySelective(teacher);
        return 0;
    }

    public int updateByPrimaryKeySelective(Tc tc){
        this.tcDao.updateByPrimaryKeySelective(tc);
        return 0;
    }

    public Teacher getTeacherByNum(String teacherNum){
        return this.teacherDao.getTeacherByNum(teacherNum);
    }

    public List<Teacher> getTeacherByCurrentPage(HashMap map){
        return this.teacherDao.getTeacherByCurrentPage(map);
    }

    public void insert(Teacher record){
        int result=this.teacherDao.insert(record);
    }

    public void insertTc(Tc record){
        int result=this.tcDao.insert(record);
    }

    public int getAllTeacherCount(){return this.teacherDao.getAllTeacherCount();}

    public int deleteByPrimaryKey(Integer teacherid){
        return  this.teacherDao.deleteByPrimaryKey(teacherid);
    }
    public List<Teacher> getTeacherListByNum(String teachernum){
        return this.teacherDao.getTeacherListByNum(teachernum);
    }
    public int deleteFromTcByTeachernum(String teachernum){
        return this.tcDao.deleteByTeachernum(teachernum);
    }
}
