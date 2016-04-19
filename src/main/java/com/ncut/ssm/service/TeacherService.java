package com.ncut.ssm.service;

import com.ncut.ssm.pojo.Tc;
import com.ncut.ssm.pojo.Teacher;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ZY on 2016/4/11.
 */
public interface TeacherService {
    public Teacher getTeacherByNum(String teacherNum);

    public List<Teacher> getTeacherByCurrentPage(HashMap map);

    public void insert(Teacher record);

    public void insertTc(Tc record);

    public int getAllTeacherCount();

    public int updateByPrimaryKeySelective(Teacher teacher);

    public Teacher selectByPrimaryKey(Integer teacherid);

    public int updateByPrimaryKeySelective(Tc tc);

    public int deleteByPrimaryKey(Integer teacherid);

    public int deleteFromTcByTeachernum(String teachernum);

    public List<Teacher>getTeacherListByNum(String teachernum);
}
