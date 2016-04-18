package com.ncut.ssm.service.serviceImpl;

import com.ncut.ssm.mapper.CourseMapper;
import com.ncut.ssm.pojo.Course;
import com.ncut.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cqq on 2016/4/18.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseDao;

    public List<Course> getAllCourse() {
        return this.courseDao.getAllCourse();
    }
}