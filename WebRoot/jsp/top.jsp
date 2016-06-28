<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<c:if test="${sessionScope.user != null }">
			<li><a href="/pet/TypeController?type=initAddPet">发布帖子</a></li>
			<li><a href="/pet/PetController?type=userShowPetList">我的帖子</a></li>
			<li><a href="/pet/PetController?type=lookReply">我的回复</a></li>
			<li><a href="/pet/jsp/personal.jsp">个人信息</a></li>
			
		</c:if>
		<c:if test="${sessionScope.user == null }">
			<li><a href="/pet/jsp/register.jsp">欢迎注册</a></li>
		</c:if>
			<li><a href="/pet/jsp/login.jsp">欢迎登陆</a></li>
			<li><a href="">宠物主页</a></li>
		</ul>
	</div>
</body>
</html>
