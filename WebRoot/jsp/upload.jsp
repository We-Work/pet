<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
	<link rel="stylesheet" type="text/css" href="/pet/css/upload.css">
	<script type="text/javascript" src="/pet/js/upload.js"></script>
  </head>
  
  <body>
  <jsp:include page="top.jsp"/>
  <div class="topic">
  <form action="/pet/PetController" name="f1" onsubmit="return check();" method="post" enctype="multipart/form-data">
  <div><span class="title">发表新帖</span></div>
  <div class="topic_content">
  <div>
  <select name="pet_type">
  	<option value="">请选择主题分类</option>
  	<c:forEach items="${requestScope.typeList }" var="type">
  	<option value="${type.typeId }">${type.typeName }</option>
  	</c:forEach>
  </select>
  <span>标题：</span>
  <input type="text" name="pet_title" class="editor_title" maxlength="15">
  </div>
 	<div class="pic_box">
 	<span>插入图片:</span>
 	<input type="file" name="file1" accept=".jpg,.jpeg,.png">
 	<input type="file" name="file2" accept=".jpg,.jpeg,.png">
 	<input type="file" name="file3" accept=".jpg,.jpeg,.png">
 	</div>
 	<div class="text_box">
  	<textarea class="text" rows="20" cols="80" name="pet_introd"></textarea>
	</div>
	<div class="btn">
  	<input type="submit" value="上传">
  	<input type="hidden" name="pet_user_id" value="${sessionScope.user.userId }">
  	<input type="hidden" name="type" value="addPet">
  	
  	</div>
  	</div>
  </form>
  </div>
  </body>
</html>
