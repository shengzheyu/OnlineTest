package com.ncut.ssm.controller;

import com.ncut.ssm.pojo.Admin;
import com.ncut.ssm.pojo.Student;
import com.ncut.ssm.pojo.Teacher;
import com.ncut.ssm.service.AdminService;
import com.ncut.ssm.service.StudentService;
import com.ncut.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZY on 2016/4/11.
 *
 * 所有用户的登录操作
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int stuId = Integer.parseInt(request.getParameter("id"));
     //   Student student = this.studentService.getStudentByNum(stuId);
      //  model.addAttribute("student", student);
        return "user_message";
    }

    @RequestMapping("/Login")
    public String Login(HttpServletRequest request,Model model){
        String loginname = request.getParameter("loginname");
        String loginpassword = request.getParameter("loginpassword");
        String authority = request.getParameter("authority");

        if(loginname==null||loginpassword==null||authority==null)
            return "error";
        //固定用userNum为登录名
        if (authority.equals("学生")){
            Student student = studentService.getStudentByNum(loginname);
            System.out.print(student);
            if(student!=null&&student.getPassword().equals(loginpassword)){
                model.addAttribute("username",loginname);
                return "success";
            }else
                return "error";
        }else if (authority.equals("老师")){
            Teacher teacher = teacherService.getTeacherByNum(loginname);
            System.out.print(teacher);
            if(teacher!=null&&teacher.getPassword().equals(loginpassword)){
                model.addAttribute("username",loginname);
                return "success";
            }else
                return "error";
        }else if (authority.equals("管理员")){
            Admin admin = adminService.getAdminByNum(loginname);
            System.out.print(admin);
            if(admin!=null&&admin.getPassword().equals(loginpassword)){
                model.addAttribute("username",admin.getName());
                return "/admin/admin_index";
            }else
                return "error";
        }
        return "error";
    }

}
