<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/pet/css/common.css">
<link rel="stylesheet" type="text/css" href="/pet/css/home.css">

</head>

<body>
	<jsp:include page="top.jsp" />
	<div class="index-main">
		<div class="tips">
			<h1>
				<span class="yel">点击查看回复信息： 
			</h1>
		</div>
		<div class="block_content">
			<ul>

				<c:forEach items="${requestScope.petUserList }" var="pet">
					<li>
						<div class="cbox">
							<hr>
							<div class="word">
								<table border="0" cellpadding="3" cellspacing="2" style="border-bottom:1px solid; ">									 
										<tr >
										<td align="left" width="70%"><b><a href="/pet/PetController?type=petShow&pet_id=${pet.petId }">${pet.petTitle }</a></b></td>
										<td align="right" width="29%">日期：${pet.petDate}</td>
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
						<li><a href="/pet/PetController?type=lookReply&pageNow=1">首页</a></li>
						<c:if test="${pageBean.pageNow - 1 > 0}">
							<li><a
								href="/pet/PetController?type=lookReply&pageNow=${pageBean.pageNow - 1 }">上一页</a></li>
						</c:if>

						<c:set value="${(pageBean.pageNow - 1) / 10 + 1 }" var="d" />
						<c:set value="${(d-1) * 10 +1 }" var="s" />

						<c:forEach begin="${s }" end="${s + 10 }" var="i">
							<c:if test="${i <= pageBean.pageCount }">
								<li><a
									href="/pet/PetController?type=lookReply&pageNow=${i }">${i }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${pageBean.pageNow + 1 < pageBean.pageCount }">
							<li><a
								href="/pet/PetController?type=lookReply&pageNow=${pageBean.pageNow + 1 }">下一页</a></li>
						</c:if>
						<li><a
							href="/pet/PetController?type=lookReply&pageNow=${pageBean.pageCount }">最后一页</a></li>
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
