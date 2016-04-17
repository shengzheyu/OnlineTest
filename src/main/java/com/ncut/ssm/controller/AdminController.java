package com.ncut.ssm.controller;


import com.ncut.ssm.pojo.Admin;
import com.ncut.ssm.pojo.HotGirlGroup;
import com.ncut.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ZY on 2016/4/12.
 * 进入管理员界面后，的一些操作
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/Welcome")//首页显示
    public String Welcome(HttpServletRequest request, Model model){
        model.addAttribute("OT","你愁啥！");
        return "welcome";
    }

    @RequestMapping("/Test")//跳转编辑管理员界面
    public String test(HttpServletRequest request, Model model){

        return "admin/test";
    }

    @RequestMapping("/AdminEdit")//跳转编辑管理员界面
    public String AdminEdit(HttpServletRequest request, Model model){

        //获取前台新增管理员信息
        String username = request.getParameter("username");//真实姓名
        String loginname = request.getParameter("loginname");//登陆名
        String loginpass = request.getParameter("loginpass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String remark = request.getParameter("remark");
        int age = Integer.valueOf(request.getParameter("age"));
        int adminid = Integer.valueOf(request.getParameter("adminid"));

        //存入对象
        Admin admin = new Admin();
        admin.setAdminnum(loginname);
        admin.setPassword(loginpass);
        admin.setName(username);
        admin.setEmail(email);
        admin.setPhone(phone);
        admin.setSex(sex);
        admin.setRemark(remark);
        admin.setAge(age);
        admin.setAdminid(adminid);

        adminService.updateByPrimaryKeySelective(admin);

        return "EditADminSuccess";
    }

    @RequestMapping("/AdminEditJump")//跳转编辑管理员界面
    public String AdminEditJump(HttpServletRequest request, Model model,String adminId){

        System.out.print(adminId);
        System.out.print(adminId);
        request.setAttribute("adminId",adminId);
        int adminid = Integer.valueOf(adminId);
        Admin admin = adminService.selectByPrimaryKey(adminid);
        request.setAttribute("Admin",admin);
        return "admin/admin_edit";
    }

    @RequestMapping("/AdminDelete")//跳转新增管理员界面
    public String AdminDelete(HttpServletRequest request, Model model,String adminNum){

        //前台获取到了要删除的Admind的唯一登录名，即工作证号对应数据库中的adminnum
        System.out.print(adminNum);
        adminService.deleteAdminByAdminNum(adminNum);
        System.out.print("deletesuccess");

        return "DeleteAdminSuccess";
    }

    @RequestMapping("/AdminAddJump")//跳转新增管理员界面
    public String AdminAddJump(HttpServletRequest request, Model model){
        return "admin/admin_add";
    }

    @RequestMapping("/AdminAdd")//跳转新增管理员界面
    public String AdminAdd(HttpServletRequest request, Model model){

        //获取前台新增管理员信息
        String username = request.getParameter("username");//真实姓名
        String loginname = request.getParameter("loginname");//登陆名
        String loginpass = request.getParameter("loginpass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String remark = request.getParameter("remark");
        int age = Integer.valueOf(request.getParameter("age"));

        //存入对象
        Admin admin = new Admin();
        admin.setAdminnum(loginname);
        admin.setPassword(loginpass);
        admin.setName(username);
        admin.setEmail(email);
        admin.setPhone(phone);
        admin.setSex(sex);
        admin.setRemark(remark);
        admin.setAge(age);

        //获取当前日期时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String jointime=format.format(date);

        admin.setJointime(jointime);

        //inster 到数据库
        adminService.insertAdmin(admin);

       // return "admin/admin_list";
        return "AddAdminSuccess";
    }

    @RequestMapping("/AdminList")//显示Admin列表
    public String AdminList(HttpServletRequest request, Model model){

        List<Admin> AdminList = adminService.getAllAdmin();

        request.setAttribute("AdminList",AdminList);
        model.addAttribute("AdminListModel",AdminList);
        return "admin/admin_list";
    }

    @RequestMapping("/showGirlsPic")//展示美女图片
    public String showPic(HttpServletRequest request, Model model,String groupnum) {

        //根据组别，从数据库中HotGirlPic中取出所有路径，此时上面应该是会要传参了
        System.out.println(groupnum);
        System.out.println(Integer.valueOf(groupnum));
        //获得对应组号的组名不知道为啥不能返回值直接是String
        String picGroup= adminService.getGroupNameByGroupNum(Integer.valueOf(groupnum)).getHotgirlgroupname();
        //get图库中对应group的所有图片的路径，一个group的固定统一放在一个文件夹下
        String PictureDirectory=adminService.selectByHotGirlGroupNum(Integer.valueOf(groupnum));
        //得到路径下所有图片名，拼串成为：  路径/文件名
        List<String> list = getHotGirlsPicName(PictureDirectory);
        List<String> picList = new ArrayList<String>();
        for(String pic:list){
            pic=groupnum+"/"+pic;
            System.out.print(pic);
            picList.add(pic);
        }
        System.out.print(picList);
        request.setAttribute("picList",picList);
        request.setAttribute("picGroup",picGroup);
        request.setAttribute("picNum",list.size());
        return "admin/girlspicture_show";
    }

    @RequestMapping("/showGirlsPicList")//展示list
    public String toIndex(HttpServletRequest request, Model model) {

        //从HotGirlGroup表中获取列表中的图片组别
        List<HotGirlGroup> hotGirlGroup = adminService.getAllGroup();
        int groupCount = adminService.getAllGroupCount();
        request.setAttribute("hotGirlGroup",hotGirlGroup);
        request.setAttribute("groupCount",groupCount);
        model.addAttribute("hotGirlGroup", hotGirlGroup).addAttribute("groupCount",groupCount);

        return "admin/girlspicture_list";
    }

    /**
     * zy@2016.4.12
     * 获取文件中所有文件名
     */
    public List<String> getHotGirlsPicName(String path)
    {
       // path = "E:\\GetHotGirlsPic";
        int i=0;
        File HotGirlsPicName = new File(path);
        String[] hotGirlsPicName = HotGirlsPicName.list();
        for(String picname:hotGirlsPicName)
        {
            System.out.println(picname);
         //   System.out.println(picname.split("\\.jpg")[0]);
            i++;
        }
        System.out.println("一共有："+ i + "张图");
        //将String[]转换成List
        List<String> HotGirlsPicNameList=new ArrayList();
        HotGirlsPicNameList= Arrays.asList(hotGirlsPicName);

        return HotGirlsPicNameList;
    }

}
