<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ncut.ssm.pojo.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	int i = 0;
	List<Teacher> TeacherList = (List<Teacher>)request.getAttribute("TeacherList");
	Integer allTeacherCount=(Integer)request.getAttribute("allTeacherCount");
	String currentpage=(String)request.getAttribute("currentpage");
	String pagecount=(String)request.getAttribute("pagecount");
	//int TeacherNum = TeacherList.size();
%>
<!DOCTYPE HTML>
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
<link href="/olt/css/style.css" rel="stylesheet" type="text/css" />
<link href="/olt/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>品牌管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 品牌管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20" id="title1">
	<div class="text-c">
		<form class="/olt/Huiform" method="post" action="" target="_self">
			<input type="text" placeholder="分类名称" value="" class="input-text" style="width:120px">
			<span class="btn-upload form-group">
			<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly  datatype="*" nullmsg="请添加附件！" style="width:200px">
			<a href="javascript:void(0);" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
			<input type="file" multiple name="file-2" class="input-file">
			</span> <span class="select-box" style="width:150px">
			<select class="select" name="brandclass" size="1">
				<option value="1" selected>国内品牌</option>
				<option value="0">国外品牌</option>
			</select>
			</span><button type="button" class="btn btn-success" id="" name="" onClick="picture_colume_add(this);"><i class="Hui-iconfont">&#xe600;</i> 添加</button>
		</form>
	</div>
	<form id="showTeacherList" class="/olt/Huiform" method="post" action="/teacher/TeacherList" target="_self">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
			<a href="javascript:;" onclick="addteacher()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 添加教师</a>
		</span>
	</div>
	<div class="mt-20">
		<div class="dataTables_wrapper no-footer" id="DataTables_Table_0_wrapper">
			<div id="DataTables_Table_0_length" class="dataTables_length">
				<label>显示 <select id="pagecount" name="pagecount" onchange="changePageCount()" class="select" aria-controls="DataTables_Table_0" >
					<option value="10" >10</option>
					<option value="15" >15</option>
					<option value="20" >20</option>
					<option value="50" >50</option>
				</select> 条</label>
			</div>
			<div class="dataTables_filter" id="DataTables_Table_0_filter">
				<label>从当前数据中检索:<input aria-controls="DataTables_Table_0" class="input-text " type="search"></label>
			</div>
			<table class="table table-border table-bordered table-bg">
				<thead>
				<tr>
					<th scope="col" colspan="9">管理员列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="150">登录名</th>
					<th width="90">姓名</th>
					<th width="150">年龄</th>
					<th>角色</th>
					<th width="130">电话号</th>
					<th width="100">是否已启用</th>
					<th width="100">操作</th>
				</tr>
				</thead>
				<tbody>
				<%
					for (Teacher teacher:TeacherList)
					{
						i++;
				%>
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td><%=i%></td>
					<td><%=teacher.getTeachernum()%></td>
					<td><%=teacher.getName()%></td>
					<td><%=teacher.getAge()%></td>
					<td>老师</td>
					<td><%=teacher.getPhone()%></td>
					<td class="td-status"><span class="label label-success radius">已启用</span></td>
					<td class="td-manage"><a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','/admin/AdminEditJump?adminId=<%=teacher.getTeacherid()%>','19930511','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_del(this,'<%=teacher.getTeachernum()%>')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				<%
					}
				%>

				</tbody>
			</table>
			<div aria-live="polite" role="status" id="DataTables_Table_0_info" class="dataTables_info"><span class="r">共有数据：<strong><%=allTeacherCount%></strong> 条</span></div>
			<div id="DataTables_Table_0_paginate" class="dataTables_paginate paging_simple_numbers">
				<input id="DataTables_Table_0_previous" type="submit" tabindex="0" data-dt-idx="0" aria-controls="DataTables_Table_0" class="paginate_button previous disabled" value="上一页" onclick="changeList('DataTables_Table_0_previous')"/>
				<span><input type="text" readonly="true" style="width:30px"  id="currentpage" name="currentpage" tabindex="0" data-dt-idx="1" aria-controls="DataTables_Table_0" class="paginate_button current" value="<%=currentpage%>" /></span>
				<input id="DataTables_Table_0_next" type="submit" tabindex="0" data-dt-idx="2" aria-controls="DataTables_Table_0" class="paginate_button next disabled" value="下一页" onclick="changeList('DataTables_Table_0_next')" />
			</div>
		</div>
	</div>
	</form>
</div>
<script type="text/javascript" src="/olt/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/olt/lib/layer/1.9.3/layer.js"></script><script type="text/javascript" src="/olt/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="/olt/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/olt/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/olt/js/H-ui.js"></script>
<script type="text/javascript" src="/olt/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/olt/js/H-ui.admin.product.js"></script>

<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
});
	/*
	* 实现上一页和下一页
	* */
	function changeList(str){
		var currentpage=document.getElementById("currentpage").value
		if(str=="DataTables_Table_0_previous"){
			if(currentpage<=1) {
				alert("已经是第一页了")
				return false
			}
			document.getElementById("currentpage").value=parseInt(currentpage)-1;
		}
		if(str=="DataTables_Table_0_next"){
			var allpagecount=${allTeacherCount}/${pagecount};
			if(currentpage>=allpagecount) {
				alert("已经是最后一页了")
				return false
			}
			document.getElementById("currentpage").value=parseInt(currentpage)+1;
		}
	}
	/*
	* 实现改变页面显示数量
	* */
	var x=${pagecount};
	var sel=document.getElementById("pagecount");
	for(var i=0;i<sel.options.length;i++){
		if(sel.options[i].value==x){
			sel.options[i].selected=true;
			break;
		}
	}
 	function changePageCount(){
		window.showTeacherList.submit();
	}
	/*
	* 实现弹出添加教师界面
	* */
	function addteacher(){
		layer_show("添加教师","AddTeacher","800","500")
	}
 </script>
</body>
</html>