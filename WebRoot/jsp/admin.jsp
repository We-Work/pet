<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="adminTop">
    	<ul>
    		<li><a href="jsp/adminPet.jsp">所有帖子</a></li>
    		<li><a href="jsp/adminRelease.jsp">帖子审核</a></li>
    		<li><a href="jsp/adminComment.jsp">评论管理</a></li>
    	</ul>
    </div>
  </body>
</html>
