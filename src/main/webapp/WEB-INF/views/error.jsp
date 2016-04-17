<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>js定时跳转页面的方法</title>
</head>
<body>
<script type="text/javascript">
	var t=5;//设定跳转的时间
	setInterval("refer()",1000); //启动1秒定时
	function refer(){
		if(t==0){
			location="http://10.5.110.215:8080"; //#设定跳转的链接地址
		}
		document.getElementById('show').innerHTML="登录信息有误，将在"+t+"秒后跳转到在线考试系统"; // 显示倒计时
		t--; // 计数器递减
		//本文转自：
	}
</script>
<span id="show"></span>
</body>
</html>
