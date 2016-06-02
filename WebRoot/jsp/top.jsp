<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    <style type="text/css">
	.a{
		list-style-type: none;
		float: right;
		margin-right: 10px;
	}
	.top{
		background-color:scrollbar;
		width: 100%;
		height: 70px;
		margin: 0px;
	}
</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="margin: 0px;">
	<div class="top">
		<ul style="margin: 0px;padding-top: 50px;padding-right: 50px;">
			<a href=""><li class="a">个人信息</li></a>
			<a href=""><li class="a">登陆</li></a>
			<a href=""><li class="a">主页</li></a>
		</ul>
	</div>
</body>
</html>
