<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帖子审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/adminPet.css">

  </head>
  
  <body>
  	<jsp:include page="admin.jsp"></jsp:include>
  	<div>
  		<h4>待审核帖子</h4>
  		<div>
  		<ul class="block_content">
  			<li>
  			<div class="cbox">
  			<hr>
  			<!-- 宠物图片 -->
  			<div class="pet_pic"><img src="/pet/images/1.jpg"/></div>
  			<div class="word">
  			<div class="box_title"><strong><a href="#">纯种古牧狗，母狗2岁，希望找个好人家领养，特别听话</a></strong></div>
  			</div>
  			<div class="info">
  			<div class="auto">
  			<img src="/pet/images/noavatar_small.gif" width="26px" height="26px;"/>
  			<a href="#">北京桃子妈妈</a>
  			</div>
  			<div class="date"><i></i><span>2016-06-01</span></div>
  			</div>
  			<div class="des">可爱的小母猫招聘铲屎官，小猫咪已绝育，特长卖萌，吃饭饭，求抱抱，真心想包养它就联系我，走国际领养程序，网红小猫抱回家！送养人联系方式QQ672906
			...</div>
			<div class="delete">
			<a href="">删除</a>&nbsp;
			<a href="">通过审核</a>
			</div>
			</div>
  			</li>
  			
  			<li>
  			<div class="cbox">
  			<hr>
  			<!-- 宠物图片 -->
  			<div class="pet_pic"><img src="/pet/images/1.jpg"/></div>
  			<div class="word">
  			<div class="box_title"><strong><a href="#">纯种古牧狗，母狗2岁，希望找个好人家领养，特别听话</a></strong></div>
  			</div>
  			<div class="info">
  			<div class="auto">
  			<img src="/pet/images/noavatar_small.gif" width="26px" height="26px;"/>
  			<a href="#">北京桃子妈妈</a>
  			</div>
  			<div class="date"><i></i><span>2016-06-01</span></div>
  			</div>
  			<div class="des">可爱的小母猫招聘铲屎官，小猫咪已绝育，特长卖萌，吃饭饭，求抱抱，真心想包养它就联系我，走国际领养程序，网红小猫抱回家！送养人联系方式QQ672906
			...</div>
			<div class="delete">
			<a href="">删除</a>&nbsp;
			<a href="">通过审核</a>
			</div>
			</div>
  			</li>
  			
  			<li>
  			<div class="cbox">
  			<hr>
  			<!-- 宠物图片 -->
  			<div class="pet_pic"><img src="/pet/images/1.jpg"/></div>
  			<div class="word">
  			<div class="box_title"><strong><a href="#">纯种古牧狗，母狗2岁，希望找个好人家领养，特别听话</a></strong></div>
  			</div>
  			<div class="info">
  			<div class="auto">
  			<img src="/pet/images/noavatar_small.gif" width="26px" height="26px;"/>
  			<a href="#">北京桃子妈妈</a>
  			</div>
  			<div class="date"><i></i><span>2016-06-01</span></div>
  			</div>
  			<div class="des">可爱的小母猫招聘铲屎官，小猫咪已绝育，特长卖萌，吃饭饭，求抱抱，真心想包养它就联系我，走国际领养程序，网红小猫抱回家！送养人联系方式QQ672906
			...</div>
			<div class="delete">
			<a href="">删除</a>&nbsp;
			<a href="">通过审核</a>
			</div>
			</div>
  			</li>
  		</ul>
  		</div>
  	</div>
  </body>
</html>
