<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<link rel="stylesheet" type="text/css" href="/pet/css/particulars.css">
<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
<script type="text/javascript" src="/pet/js/jquery-2.2.2.js"></script>
<script type="text/javascript" src="/pet/js/particulars.js"></script>
</head>

<body>
	<jsp:include page="top.jsp" />
	<div class="div0">
		<div class="div1">
			<div class="title1">
				<br>&ensp; <font color="gray" size="+2">${requestScope.pet.petTitle }</font>
				<!-- <font color="gray"><a href="">[复制链接]</a></font> -->
			</div>
			<div class="title2">
				&ensp;&ensp;<img style="border-radius:50%" src="/pet/images/touxiang.gif"><img
					src="/pet/images/sucai1.jpg" align="middle"><span>1958</span>&ensp;
				<img src="/pet/images/sucai2.jpg" align="middle"><span>2</span>
				&ensp; <span>${requestScope.pet.user.userName }</span>&ensp;发表于&ensp;${requestScope.pet.petDate }
			</div>
			<div class="title3">
				<div style="margin-left: 20px; margin-right: 20">
					${requestScope.pet.petIntrod }</div>
					
					<!-- 图片 -->
				<c:if test="${pet.petPic1 != null }">
				<div class="pic">
					<img alt="图片" width="500" src="/pet/images/${pet.petPic1 }">
				</div>
				</c:if>
				<c:if test="${pet.petPic2 != null }">
				<div class="pic">
					<img alt="图片" width="500" src="/pet/images/${pet.petPic2 }">
				</div>
				</c:if>
				<c:if test="${pet.petPic3 != null }">
				<div class="pic">
					<img alt="图片" width="500" src="/pet/images/${pet.petPic3 }">
				</div>
				</c:if>
			</div>
			<div class="comment">
			<c:forEach items="${requestScope.com_list }" var="comment">
			<div class="com_box">
			<div class="com_title">
			<div class="com_img">
			<img src="/pet/images/touxiang.gif">
			</div>
			<div class="auth"><span><a href="/pet/UserController?type=lookPersonal&user_id=${comment.user.userId}"><strong>${comment.user.userName }</strong></a></span></div>
			<div class="time">发表于：<span>${comment.commentDate }</span></div>
			<!-- 回复连接 -->
			<div class="rp"><a href="javascript:void(0);" onclick="showReplyBox(this,'${sessionScope.user != null }')" name="reply${comment.commentId }" id="${comment.commentId }">回复</a></div>
			</div>
			<div class="com_content">${comment.commentContent }</div>
			</div>
			<c:forEach items="${comment.replyList }" var="reply">
			<div class="reply">
			<div><span><a href="/pet/UserController?type=lookPersonal&user_id=${reply.user.userId}">${reply.user.userName }</a></span> 发表于：${reply.replyDate }</div>
			<div>${reply.replyContent }</div>
			</div>
			
			</c:forEach>
			<!-- 回复框 -->
			<div class="rp_box" id="reply_box${comment.commentId }">
			</div>
			</c:forEach>
			</div>
			<div class="bottm">
			<span><strong>添加回复:</strong></span>
			<form action="/pet/CommentController" method="post" onsubmit="return checkAuthen('${sessionScope.user != null }')">
				<p>
					<textarea id="txt_comment" name='comment_content' onfocus="checkAuthen('${sessionScope.user != null }')" rows='5' cols='100' onchange="on"></textarea>
					<input type="hidden" name="type" value="addComment">
					<input type="hidden" name="comment_pet_id" value="${requestScope.pet.petId }">
				</p>
				<p>
					<input type="submit" class="btn2" value="发表回复">
				</p>
			</form>
			</div>
		</div>

	</div>
	<br>
</body>
</html>
