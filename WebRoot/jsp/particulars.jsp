<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'particulars.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.div0{width: 830px; height:900px; margin: 0 auto; background-color: white; box-shadow:2px 1px 5px 5px gray;}
		.div1{width: 810px; height: 890px; margin: 0 auto;  background-color: white;  }
		
		.title1{ height: 70px; background-color: white; width: 810px; margin:0 auto;}
		.title2{ height: 70px; background-color: white; width: 810px; margin:0 auto;}
		.title3{ height:200px; background-color: white; width: 810px; margin:0 auto;border-bottom:1px;border-bottom-style:solid;border-color:gray;}
		.bottm{ height:200px; background-color: white; width: 810px; margin:0 auto; margin-top:19.5%; position:absolute;border-top:1px;border-top-style:solid; border-color: gray;  }
		.btn1{  width:110px;height:25px; background-color:white;  border-color:gray; color: black; }		
		.btn1:hover{background-color: gray; color: white;}
		
		.btn2{width:110px;height:25px; background-color:green;  color: white;}		
		.btn2:hover{background-color: blue; color: white;}
	</style>

  </head>
  
  <body>
  	<div class="div0">
  		<div class="div1">
  			<div class="title1">
  			<br>&ensp;	<font color="gray" size="+3">6个月大的狗狗送人啦,求爱狗人士</font>
  				<font color="gray"><a href="">[复制链接]</a></font>
  			</div>
  			<div class="title2">
  				&ensp;&ensp;<img src="/pet/images/touxiang.gif"><img src="/pet/images/sucai1.jpg" align="middle"><span>1958</span>&ensp;
  				
  				<img src="/pet/images/sucai2.jpg" align="middle"><span>2</span>
  				&ensp; <span>用户名</span>&ensp;发表于&ensp;2016-05-17&ensp;10:27:07
  			</div>
  			<div class="title3">
  			
		深圳福田串串狗狗免费送养，QQ：982946077
  			</div>
  			
  				<div class="bottm">
			<br>
		
			<input type="button" class="btn1"  value="返回列表" / >
			<input type="button" class="btn1"  value="上一页" / >
			<input type="button" class="btn1"  value="下一页" / >
			<br>
			<p>
				<input type="text" style="height: 92px; width: 100%; ">
			</p>
			<p>
				<input type="button" class="btn2"  value="发表回复" / >
			</p>
			
  			</div>
  		</div>
  	
  		</div>
   <br>
  </body>
</html>
