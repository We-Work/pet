<%@ page language="java" import="java.util.*,org.fjzzy.domain.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'personal.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/pet/css/personal.css">
<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
<jsp:include page="top.jsp" />
</head>

<body>
	<c:if test="${requestScope.user!=null}">
	<c:set value="${requestScope.user}" var="user"></c:set>
		<div class="div0">
			<div class="div1">
				<div class="title1"></div>
				<div class="title2">
					<br>&nbsp;&nbsp;<b>基本资料</b>
				</div>
				<div class="title3">

					<div class="middle">
						<font style="font-family: 华文行楷; color: red;">（${user.userName}）
						</font>的个人信息页面。
						<p>
							<c:if test="${user.userSex=='男'}">他</c:if><c:if test="${user.userSex=='女'}">她</c:if>的头像：<img alt="" src="../pet/images/touxiang.gif">
						</p>
						<p>
							<font color="red">*</font>昵称：&nbsp;&nbsp;&nbsp;${user.userName}<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
						</p>

						<p>
							<font color="red">*</font>性别：&nbsp;&nbsp;&nbsp;${user.userSex}
						</p>
						<p>
							<font color="red"></font>电话号码：${user.userTel}
						</p>
						<p>
							地址：&nbsp;&nbsp;&nbsp;&nbsp;${user.userAddress}
						</p>
					</div>
					
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><input type="button"
							class="btn2" value="返回首页"></a>
							
							
					</p>

				</div>

				<div class="bottm">
					<br>
				</div>
			</div>
		</div>
		<br>
	</c:if>
</body>
</html>
