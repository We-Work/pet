<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>评论管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
	<link rel="stylesheet" type="text/css" href="/pet/css/home.css">

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <div>
    	<h4>所有评论</h4>
    	<div class="block_content">
			<ul>
				<c:forEach items="${requestScope.commentList }" var="Comment">
					<li>
						<div>
							<hr>
							<div class="word">
								<table border="0" cellpadding="3" cellspacing="2">									 
										<tr >
										<td align="left" width="60%">${Comment.commentContent}</td>
										<td align="right" width="25%">日期：${Comment.commentDate}</td>
										<td align="right" width="8%">${Comment.user.userName}</td>
										<td align="right"><a href="/pet/CommentController?type=delComment&comment_id=${Comment.commentId}">删除</a></td>
										</tr>								
								</table>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>

		</div>
		<!-- 分页 -->
		<c:set value="${requestScope.pageBean }" var="pageBean" />
		<div class="paging">
			<center>
				<div class="p_link">
					<ul>
						<li><a href="/pet/CommentController?type=adminComment&pageNow=1">首页</a></li>
						<c:if test="${pageBean.pageNow - 1 > 0}">
							<li><a
								href="/pet/CommentController?type=adminComment&pageNow=${pageBean.pageNow - 1 }">上一页</a></li>
						</c:if>

						<c:set value="${(pageBean.pageNow - 1) / 10 + 1 }" var="d" />
						<c:set value="${(d-1) * 10 +1 }" var="s" />

						<c:forEach begin="${s }" end="${s + 10 }" var="i">
							<c:if test="${i <= pageBean.pageCount }">
								<li><a
									href="/pet/CommentController?type=adminComment&pageNow=${i }">${i }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${pageBean.pageNow + 1 < pageBean.pageCount }">
							<li><a
								href="/pet/CommentController?type=adminComment&pageNow=${pageBean.pageNow + 1 }">下一页</a></li>
						</c:if>
						<li><a
							href="/pet/CommentController?type=adminComment&pageNow=${pageBean.pageCount }">最后一页</a></li>
					</ul>
				</div>
			</center>
			<center>
				<div class="paging_tip">
					<span>现在第<strong>${pageBean.pageNow }</strong>页 / 共<strong>${pageBean.pageCount }</strong>页
					</span>
				</div>
			</center>
		</div>
    </div>
  </body>
</html>
