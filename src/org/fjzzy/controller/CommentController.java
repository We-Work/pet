package org.fjzzy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.User;
import org.fjzzy.service.CommentService;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		
		HttpSession session = request.getSession();
		
		CommentService commentService = new CommentService();
		
		if("addComment".equals(type)){
			addComment(request, response, session, commentService);
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
