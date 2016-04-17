package com.ncut.ssm.service.serviceImpl;

import com.ncut.ssm.mapper.StudentMapper;
import com.ncut.ssm.pojo.Student;
import com.ncut.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by ZY on 2016/4/11.
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentDao;

    public Student getStudentByNum(String studentNum) {
        return this.studentDao.getStudentByNum(studentNum);
    }
}
