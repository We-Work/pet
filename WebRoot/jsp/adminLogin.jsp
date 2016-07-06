<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/pet/css/login.css">
	<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
	<script type="text/javascript" src="/pet/js/adminlogin.js"></script>
	

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="login">
  		<div class="tab">
  		<div class="tab_title">
  		<div class="word"><strong>管理员登录</strong></div>
  		<hr>
  		</div>
  		
		<form name="login_form" id="form1" action="/pet/AuthenController" method="post">
			<table width="500px" height="250px;">
			<tr>
				<td class="lab"><label>用户名</label></td>
				<td width="200px;"><input name="admin_name" type="text" width="200px;"></td>
			</tr>
			
			<tr>
				<td class="lab"><label>密码</label></td>
				<td><input name="admin_pwd" type="password" width="200px;"></td>
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
				<td><input type="hidden" name="type" value="adminlogin"></td>
				<td><input type="button" id="comfirm" onclick="checkCode()" value="登录"></td>
				<td><span style="color: red;" id="msg"></span></td>
			</tr>
			</table>
		</form>  		
				<!-- 检查是否登录失败 -->
				<script type="text/javascript">
					if(location.href.search(/loginError/)> 0){
						document.getElementById("msg").innerHTML = "登录失败";
					}
				</script>
  		</div>
  	</div>
  </body>
</html>
