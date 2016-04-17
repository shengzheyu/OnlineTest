package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher getTeacherByNum(String teacherNum);
}