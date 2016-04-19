package com.ncut.ssm.mapper;

import com.ncut.ssm.pojo.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getAllCourse();

    List selectCourseNumByTeacherNum(String teachernum);

    List<Course> selectCourseNameByCourseNum(List<Course> courseList);
}