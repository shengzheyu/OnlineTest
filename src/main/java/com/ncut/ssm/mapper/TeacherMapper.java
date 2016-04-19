package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher getTeacherByNum(String teacherNum);

    List<Teacher> getTeacherByCurrentPage(HashMap map);

    int getAllTeacherCount();

    List<Teacher> getTeacherListByNum(String teachernum);


}