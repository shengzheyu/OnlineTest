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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by cqq on 2016/4/14.
 * Modify by zy on 2016/4/18
 * 增加教师的编辑和删除
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;



    @RequestMapping("/TeacherDelete")
    public String TeacherDelete(HttpServletRequest request,Model model){
        String teachernum=request.getParameter("teachernum");
        Integer teacherid=Integer.parseInt(request.getParameter("teacherid"));
        try {
            this.teacherService.deleteByPrimaryKey(teacherid);
            this.teacherService.deleteFromTcByTeachernum(teachernum);
            return "DeleteSuccess";
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "";
    }

    @RequestMapping("/TeacherEdit")//跳转编辑管理员界面
    public String TeacherEdit(HttpServletRequest request, Model model){

        String teacherId = request.getParameter("teacherid");
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
        try{
            List<Teacher> list=this.teacherService.getTeacherListByNum(teacherNum);
            if(list.size()!=0)
                return "alreadyexist";
        }catch (Exception e){
            System.out.println(e);
        }
       /**
        * 编辑功能中课程需要改进成checkbox，所以暂时不做编辑处理
        */
       /* Tc tc=new Tc();
        tc.setTeachernum(teacherNum);
        tc.setCoursenum(course);*/
        try {
            this.teacherService.updateByPrimaryKeySelective(teacher);
         //   this.teacherService.insertTc(tc);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "editTeacherSuccess";
    }

    @RequestMapping("/TeacherEditJump")//跳转编辑界面
    public String TeacherEditJump(HttpServletRequest request, Model model,String TeacherId){

        System.out.print(TeacherId);
    //    System.out.print(tcid);
        request.setAttribute("teacherId",TeacherId);
        int teacherid = Integer.valueOf(TeacherId);
        Teacher teacher = teacherService.selectByPrimaryKey(teacherid);
        request.setAttribute("Teacher",teacher);
        List<Course> courseList=this.courseService.getAllCourse();
        model.addAttribute("courseList",courseList);

        return "teacher/teacher_edit";
    }

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
            //教师数量
            allTeacherCount=this.teacherService.getAllTeacherCount();
        }
        catch (Exception e){
            System.out.println(e);
        }

        List<HashMap> coursenumList = new ArrayList();
        List<List<HashMap>> allCourseList = new ArrayList<>();

        int i=0;
        /*************添加课程List**********************/
        for(Teacher teacher:list){
            String teachernum = teacher.getTeachernum();
            coursenumList = courseService.selectCourseNumByTeacherNum(teachernum);//获得 coursename and tcid
            allCourseList.add(coursenumList);

            List<HashMap> courseList=allCourseList.get(i);
            String str="";
            int j=0;
            for(HashMap hashMap:courseList){
                if(j<courseList.size()){
                    str+=(String)hashMap.get("coursename");
                    str+=",";
                }else
                    str+=(String)hashMap.get("coursename");
                j++;
            }
            System.out.println(str);
            i++;
        }
        model.addAttribute("TeacherList", list);
        model.addAttribute("allCourseList",allCourseList);
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
    * 添加教师
    * */
    @RequestMapping("/AddTeacherInfo")
    @ResponseBody
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
        try{
            List<Teacher> list=this.teacherService.getTeacherListByNum(teacherNum);
            if(list.size()!=0)
                return "alreadyexist";
        }catch (Exception e){
            System.out.println(e);
        }
        Tc tc=new Tc();
        tc.setTeachernum(teacherNum);
        tc.setCoursenum(course);
        try {
            this.teacherService.insert(teacher);
            this.teacherService.insertTc(tc);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "addTeacherSuccess";
    }
}
