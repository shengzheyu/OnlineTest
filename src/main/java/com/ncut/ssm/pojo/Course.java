package com.ncut.ssm.pojo;

public class Course {
    private Integer courseid;

    private String coursenum;

    private String coursename;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(String coursenum) {
        this.coursenum = coursenum == null ? null : coursenum.trim();
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }
}