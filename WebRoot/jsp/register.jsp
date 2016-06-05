<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/pet/css/register.css">
	<script type="text/javascript" src="/pet/js/register.js"></script>
  </head>
  
  <body>
    <div class="login">
  		<div class="tab">
  		<div class="tab_title">
  		<div class="word"><strong>用户注册</strong></div>
  		<hr>
  		</div>
  		
		<form name="login_form" id="form1" action="" method="post">
			<table width="500px" height="250px;">
			<tr>
				<td class="lab"><label>用户名</label></td>
				<td width="200px;"><input name="user_name" type="text" width="200px;"></td>
				<td width="180px;" class="link"><a href="#">立即注册</a></td>
			</tr>
			
			<tr>
				<td class="lab"><label>密码</label></td>
				<td><input name="user_pwd" type="password" width="200px;"></td>
				<td class="link"><a href="#">找回密码</a></td>
			</tr>
			
			
			<tr>
				<td class="lab"><label>性别</label></td>
				<td>
				<input type="radio" value="男" checked="checked"><label>男</label>
				<input type="radio" value="女"><label>女</label>
				</td>
				<td></td>
			</tr>
			
			<tr>
			<td class="lab"><label>手机</label></td>
			<td><input type="text" ></td>
			<td></td>
			</tr>
			
			<tr>
			<td></td>
			<td></td>
			<td></td>
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
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="button" id="comfirm" onclick="checkCode()" value="登录"></td>
				<td><span style="color: red;" id="msg"></span></td>
			</tr>
			</table>
		</form>  		
  		</div>
  	</div>
  </body>
</html>
