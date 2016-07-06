package org.fjzzy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.Pet;
import org.fjzzy.domain.User;
import org.fjzzy.service.CommentService;
import org.fjzzy.util.PageBean;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		
		HttpSession session = request.getSession();
		
		CommentService commentService = new CommentService();
		Comment comment = this.extractComment(request);
		if("addComment".equals(type)){
			addComment(request, response, session, commentService);
		}else if("adminComment".equals(type)){
			//显示评论列表
			showCommentList(request, response, session, commentService);
		}else if("delComment".equals(type)){
			//删除评论
			delComment(request, response, session, commentService, comment);
		}else if("lookReply".equals(type)){
			//查看我的回复
			lookReply(request, response, session, commentService);
		}
		
	}
	private void lookReply(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			CommentService commentService) throws ServletException, IOException {
		PageBean pageBean = new PageBean(1);
		User user=new User();
		user=(User)session.getAttribute("user");
		if(request.getParameter("pageNow") != null){
			pageBean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}		
		List<Comment> list = commentService.getCommentListByUser(pageBean, true, user);
		request.setAttribute("CommentList", list);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/jsp/lookReply.jsp").forward(request, response);
	}
	private void delComment(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			CommentService commentService, Comment comment)
			throws ServletException, IOException {
		if(session.getAttribute("admin") != null){
			boolean isDelComment = commentService.deleteComment(comment);
			if(isDelComment){
				showCommentList(request, response, session, commentService);
			}
		}
	}
	private void showCommentList(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			CommentService commentService) throws ServletException, IOException {
		if(session.getAttribute("admin") != null){
			PageBean pageBean = new PageBean(10);
			if(request.getParameter("pageNow") != null){
				pageBean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
			}else{
				pageBean.setPageNow(1);
			}
			ArrayList<Comment> list = commentService.getListByPage(pageBean, true);
			request.setAttribute("commentList", list);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/jsp/adminComment.jsp").forward(request, response);
		}
	}
	private void addComment(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			CommentService commentService) throws ServletException, IOException {
		Comment comment = extractComment(request);
		
		if(session.getAttribute("user") != null){
			User user = (User) session.getAttribute("user");
			comment.setCommentUserId(user.getUserId());
			commentService.addComment(comment);
			request.getRequestDispatcher("/PetController?type=petShow&pet_id=" + comment.getCommentPetId()).forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}
	private Comment extractComment(HttpServletRequest request) {
		Comment comment = new Comment();
		comment.setCommentId(request.getParameter("comment_id") != null ? Integer.parseInt(request.getParameter("comment_id")) : -1);
		comment.setCommentUserId(request.getParameter("comment_user_id") != null ? Integer.parseInt(request.getParameter("comment_user_id")) : -1);
		comment.setCommentPetId(request.getParameter("comment_pet_id") != null ? Integer.parseInt(request.getParameter("comment_pet_id")) : -1);
		comment.setCommentContent(request.getParameter("comment_content") != null ? request.getParameter("comment_content") : null);
		return comment;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
