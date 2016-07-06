package org.fjzzy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.Reply;
import org.fjzzy.domain.User;
import org.fjzzy.service.CommentService;
import org.fjzzy.service.ReplyService;

public class ReplyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		Reply reply = extractReply(request);
		
		ReplyService replyService = new ReplyService();
		CommentService commentService = new CommentService();
		
		if("addReply".equals(type)){
			addReply(request, response, session, reply, replyService,
					commentService);
		}
		
	}

	private void addReply(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Reply reply,
			ReplyService replyService, CommentService commentService)
			throws ServletException, IOException {
		if(session.getAttribute("user") != null){
			User user = (User) session.getAttribute("user");
			reply.setReplyUserId(user.getUserId());
			replyService.addReply(reply);
			
			int pet_id = commentService.getCommentById(reply.getReplyCommentId(), false).getCommentPetId();
			request.getRequestDispatcher("/PetController?type=petShow&pet_id=" + pet_id).forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	private Reply extractReply(HttpServletRequest request) {
		Reply reply = new Reply();
		reply.setReplyUserId(request.getParameter("reply_user_id") != null ? Integer.parseInt(request.getParameter("reply_user_id")) : -1);
		reply.setReplyCommentId(request.getParameter("reply_comment_id") != null ? Integer.parseInt(request.getParameter("reply_comment_id")) : -1);
		reply.setReplyContent(request.getParameter("reply_content") != null ? request.getParameter("reply_content") : null);
		return reply;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
