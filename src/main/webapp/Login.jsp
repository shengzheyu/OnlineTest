<%--
  Created by IntelliJ IDEA.
  User: ZY
  Date: 2016/4/11
  Time: 13:18
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
  <script type="text/javascript" src="olt/lib/html5.js"></script>
  <script type="text/javascript" src="olt/lib/respond.min.js"></script>
  <script type="text/javascript" src="olt/lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="olt/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="olt/css/H-ui.login.css" rel="stylesheet" type="text/css" />
  <link href="olt/css/style.css" rel="stylesheet" type="text/css" />
  <link href="olt/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <script type="text/javascript" src="/js/login.js"></script>

  <title>在线考试系统</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="/user/Login" method="post" onsubmit="return validate()">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="loginname" name="loginname" type="text" placeholder="用户名" value="别TM偷摸看我网站。。" class="input-text size-L" >
          <br>
          <label id="loginnameError" ></label>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="loginpassword" name="loginpassword" type="password" placeholder="密码" value="" class="input-text size-L">
          <br>
          <label id="loginpassError" ></label>
        </div>
      </div>
      <div class="row cl">
          <div class="formControls col-8 col-offset-3">
            <label>
              <input type="checkbox" name="authority" id="student" value="学生">
              学生</label>
            <label >
              <input type="checkbox" name="authority" id="teacher" value="老师">
              老师</label>
            <label>
              <input type="checkbox" name="authority" id="admin" value="管理员" >
              管理员</label>
            <br>
            <label id="authorityError" ></label>
          </div>

      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">OnlineTest 在线考试系统！ by zy/cqq</div>
<script type="text/javascript" src="olt/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="olt/js/H-ui.js"></script>
<script>
  var _hmt = _hmt || [];
  (function() {
    var hm = document.createElement("script");
    hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
  })();
  var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
  document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>
