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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/top.css">

  </head>
  
  <body>
	<div class="top">
		<div class="img">
		<img alt="" src="/pet/images/logo.png">
		<img alt="" src="/pet/images/logotext.png">
		</div>
		<ul>
			<li><a href="">个人信息</a></li>
			<li><a href="">欢迎登陆</a></li>
			<li><a href="">宠物主页</a></li>
		</ul>
	</div>
</body>
</html>
