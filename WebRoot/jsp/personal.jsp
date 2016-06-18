<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
	<jsp:include page="top.jsp"/>
</head>

<body>
	<div class="div0">
		<div class="div1">
			<div class="title1"></div>
			<div class="title2">
				<br>&nbsp;&nbsp;<b>基本资料</b>
			</div>
			<div class="title3">

				<div class="middle">
					亲爱的（摸摸摸），填写真实的资料，有助于好友找到你哦。
					<p>
						当前头像：<img alt="" src="../pet/images/touxiang.gif">
					</p>
					<p>
						<font color="red">*</font>昵称：&nbsp;&nbsp;&nbsp;<input
							name="user_name" type="text" style="width: 300px;"><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font
							color="red" size="-2">*昵称填写须知：昵称不可以太都比， 会被打！</font>
					</p>

					<p>
						<font color="red">*</font>性别：&nbsp;&nbsp;&nbsp;<input type="radio"
							id="sex1" name="user_sex" checked="checked" value="男">男 <input
							type="radio" id="sex2" name="user_sex" value="女">女
					</p>
					<p>
						<font color="red"></font>电话号码：<input type="text" name="user_tel">
					</p>
					<p>
						地址：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="user_address"
							style="width: 300px;">
					</p>
				</div>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
						class="btn2" value="保存" >
				</p>
			</div>

			<div class="bottm">
				<br>



			</div>
		</div>

	</div>
	<br>
</body>
</html>
