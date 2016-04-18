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
}
