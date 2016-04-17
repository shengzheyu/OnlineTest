package com.ncut.ssm.service.serviceImpl;

import com.ncut.ssm.mapper.TeacherMapper;
import com.ncut.ssm.pojo.Teacher;
import com.ncut.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZY on 2016/4/11.
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherDao;

    public Teacher getTeacherByNum(String teacherNum){
        return this.teacherDao.getTeacherByNum(teacherNum);
    }
}
