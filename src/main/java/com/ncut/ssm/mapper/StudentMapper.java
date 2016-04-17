package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student getStudentByNum(String studentNum);

}