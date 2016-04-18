package com.ncut.ssm.controller;

import com.ncut.ssm.pojo.Course;
import com.ncut.ssm.pojo.Tc;
import com.ncut.ssm.pojo.Teacher;
import com.ncut.ssm.service.CourseService;
import com.ncut.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cqq on 2016/4/14.
 * Modify by zy on 2016/4/18
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @RequestMapping("/TeacherList")
    public String TeacherList(HttpServletRequest request,Model model){
        String pagecount=request.getParameter("pagecount");
        String currentpage=request.getParameter("currentpage");
        List<Teacher> list=new ArrayList<Teacher>();
        int allTeacherCount=0;
        if(pagecount==null||pagecount.equals("")){
            pagecount="10";
        }
        if(currentpage==null||currentpage.equals("")){
            currentpage="1";
        }
        HashMap map=new HashMap();
        map.put("pagecount",Integer.parseInt(pagecount));
        //Mybatis中做currentpage与pagecount的运算有问题，提前在controller中处理
        map.put("currentpage",(Integer.parseInt(currentpage)-1)*Integer.parseInt(pagecount));
        try {
            list = this.teacherService.getTeacherByCurrentPage(map);
        } catch (Exception e){
            System.out.println(e);
        }
        try{
            allTeacherCount=this.teacherService.getAllTeacherCount();
        }
        catch (Exception e){
            System.out.println(e);
        }
        model.addAttribute("TeacherList", list);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("allTeacherCount",allTeacherCount);
        model.addAttribute("pagecount",pagecount);
        return "teacher/teacherlist";
    }
    /*
    * 弹出添加信息页面
    * */
    @RequestMapping("/AddTeacher")
    public String AddTeacher(HttpServletRequest request,Model model){
        List<Course> courseList=this.courseService.getAllCourse();
        model.addAttribute("courseList",courseList);
        return "teacher/addteacher";
    }
    /*
    * 添加教师信息
    * */
    @RequestMapping("/AddTeacherInfo")
    public String AddTeacherInfo(HttpServletRequest request,Model model){
        String teacherName=request.getParameter("username");
        String teacherNum=request.getParameter("loginname");
        String password=request.getParameter("loginpass");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String adress=request.getParameter("adress");
        String course=request.getParameter("course");
        Teacher teacher=new Teacher();
        teacher.setAdress(adress);
        teacher.setAge(Integer.parseInt(age));
        teacher.setEmail(email);
        teacher.setName(teacherName);
        teacher.setPassword(password);
        teacher.setPhone(phone);
        teacher.setSex(sex);
        teacher.setTeachernum(teacherNum);
        try {
            this.teacherService.insert(teacher);
        }
        catch (Exception e){
            System.out.println(e);
        }
        Tc tc=new Tc();
        tc.setTeachernum(teacherNum);
        tc.setCoursenum(course);
        try {
            this.teacherService.insertTc(tc);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "";
    }
}
