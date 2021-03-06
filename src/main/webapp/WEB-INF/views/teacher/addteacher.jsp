<%@ page import="java.util.List" %>
<%@ page import="com.ncut.ssm.pojo.Course" %>
<%--
  Created by IntelliJ IDEA.
  User: ZY
  Date: 2016/4/13
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="/olt/lib/html5.js"></script>
  <script type="text/javascript" src="/olt/lib/respond.min.js"></script>
  <script type="text/javascript" src="/olt/lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="/olt/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="/olt/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="/olt/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
  <link href="/olt/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>添加教师</title>
  <%
    List<Course> courseList=(List<Course>)request.getAttribute("courseList");
  %>

  <script type="text/javascript">
    function submit_form(obj) {
      layer.confirm('确认添加？', function (index) {
        //此处请求后台程序，下方是成功后的前台处理……
        //存数据
        var loginname = document.getElementById("username").value;
        var loginpass = document.getElementById("loginpass").value;
        var username = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        var email = document.getElementById("email").value;
        var adress = document.getElementById("adress").value;
        var course = document.getElementById("course").value;
        //age是radio类型
        var sex = $("input[name='sex']:checked").val();
        var remark = document.getElementById("remark").value;
        var age = document.getElementById("age").value;

        $.ajax({
          url: "/teacher/AddTeacherInfo",
          type: "post",
          data: {
            'username': username,
            'loginname': loginname,
            'loginpass': loginpass,
            'phone': phone,
            'age': age,
            'adress': adress,
            'email': email,
            'sex': sex,
            'course': course
          },//,sex:sex,
          error: function (XMLResponse) {
            alert(XMLResponse.responseText)
          },
          success: function (data) {
            //  alert("122213");
            if (data == "alreadyexist") {
              layer.msg('用户名已存在', {icon: 1, time: 1000});
              $("#errormessage").css("display", "");
              $("#errormessage").css("color", "red");
              $("#errormessage").text("用户名已存在！");
            }
            else {
              $("#errormessage").css("display", "none");
              layer.msg('已添加!', {icon: 1, time: 1000});
              //     parent.layer.close(index);
            }
          }
        });
      });
    }

  </script>
</head>
<body>
<div class="pd-20">
  <form action="/teacher/AdminAdd" method="post" class="form form-horizontal" id="form-teacher-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名:</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="test" placeholder="" id="username" name="username" datatype="*2-16" nullmsg="用户名不能为空">
      </div>
      <label id="errormessage"></label>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>初始密码：</label>
      <div class="formControls col-5">
        <input type="password" id="loginpass" name="loginpass" placeholder="密码" autocomplete="off" value="123456" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>
      <div class="formControls col-5">
        <input type="password" placeholder="确认密码" value="123456" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="loginpass" id="reloginpass" name="reloginpass">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>所教课程：</label>
      <div class="formControls col-5">
        <select id="course" name="course" placeholder="所教课程" autocomplete="off" class="input-text">
          <%
            String coursename;
            String coursenum;
            for(Course course:courseList) {
              coursename = course.getCoursename();
              coursenum=course.getCoursenum();
          %>
          <option value="<%=coursenum%>"><%=coursename%></option>
          <%
            }
          %>
        </select>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>姓名：</label>
      <div class="formControls col-5">
        <input type="text" id="name" name="name" placeholder="姓名" autocomplete="off" value="cqq" class="input-text" errormsg="你是王八？" datatype="*2-3" nullmsg="姓名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>年龄：</label>
      <div class="formControls col-5">
        <input type="text" id="age" name="age" placeholder="年龄" autocomplete="off" value="23" class="input-text" errormsg="你是王八？" datatype="*2-3" nullmsg="年龄不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>性别：</label>
      <div class="formControls col-5 skin-minimal">
        <div class="radio-box">
          <input type="radio" id="sex-1" value="男" name="sex" datatype="*" nullmsg="请选择性别！">
          <label for="sex-1">男</label>
        </div>
        <div class="radio-box">
          <input type="radio" id="sex-2" value="女" name="sex">
          <label for="sex-2">女</label>
        </div>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="13601121212" placeholder="" id="phone" name="phone"  datatype="m" nullmsg="手机不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="test@olt.com" placeholder="xx@xx.xx" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>住址：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  name="adress" id="adress" value="北方工业大学" datatype="e" nullmsg="请输入住址！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3">备注：</label>
      <div class="formControls col-5">
        <textarea id="remark" name="remark" cols="" rows="" class="textarea" value="test" placeholder="说点什么...50个字符以内" dragonfly="true" onKeyUp="textarealength(this,50)"></textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="button" onclick="submit_form(this)" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="/olt/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/olt/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="/olt/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="/olt/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="/olt/js/H-ui.js"></script>
<script type="text/javascript" src="/olt/js/H-ui.admin.js"></script>
<script type="text/javascript">
  $(function(){
    $('.skin-minimal input').iCheck({
      checkboxClass: 'icheckbox-blue',
      radioClass: 'iradio-blue',
      increaseArea: '20%'
    });

    $("#form-admin-add").Validform({
      tiptype:2,
      callback:function(form){
        form[0].submit();
        /*var index = parent.layer.getFrameIndex(window.name);
         parent.$('.btn-refresh').click();*/
        /*parent.layer.close(index);*/
        var index = parent.layer.getFrameIndex(window.name);
        window.parent.location.reload();
      }
    });
  });
</script>
</body>
</html>
