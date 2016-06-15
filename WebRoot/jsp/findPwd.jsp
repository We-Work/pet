<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/pet/css/login.css">
	<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
	<script type="text/javascript" src="/pet/js/findpwd.js"></script>
  </head>
  
  <body>
  <jsp:include page="top.jsp"/>
  	<div class="login">
  		<div class="tab">
  		<div class="tab_title">
  		<div class="word"><strong>找回密码</strong></div>
  		<hr>
  		</div>
  		
		<form name="find_form" id="form1" action="/pet/AuthenController" method="post">
			<table width="500px" height="250px;">
			<tr>
				<td class="lab"><label>用户名</label></td>
				<td width="200px;"><input name="user_name" type="text" width="200px;"></td>
				<td width="180px;" class="link"><a href="#">立即注册</a></td>
			</tr>
			
			<tr>
				<td class="lab"><label>手机号码</label></td>
				<td><input name="user_tel" onblur="checkTel()" onchange="checkTel()" type="text" width="200px;"></td>
				<td><span id="msg_tel" style="color:red;"></span></td>
			</tr>
			<tr>
				<td class="lab"><label>新密码</label></td>
				<td><input name="user_pwd" type="password" width="200px;"></td>
				<td class="link"></td>
			</tr>
			<tr>
				<td class="lab"><label>密码确认</label></td>
				<td><input name="user_pwd_confirm" type="password" width="200px;"></td>
				<td class="link"></td>
			</tr>
			
			<tr>
				<td class="lab"><label>验证码</label></td>
				<td><input name="securityCode" type="text" ></td>
				<td  class="link"><a href="javascript:void(0)" onclick="change()">换一个</a></td>
			</tr>
			
			<tr>
				<td></td>
				<td>输入下面图片的字符<br>
				<img alt="验证码" id="securitycode" 
				src="/pet/SecurityCodeController?opt=create"></td>
				<td><span id="msg" style="color:red;"></span></td>
			</tr>
			
			<tr>
				<td><input type="hidden" name="type" value="findPwd"></td>
				<td><input type="button" id="comfirm" onclick="checkCode()" value="修改密码"></td>
			</tr>
			</table>
		</form>  		
  		</div>
  	</div>
  </body>
</html>
