package org.fjzzy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.User;
import org.fjzzy.service.UserService;

public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//用户判断用户操作请求
		String type = request.getParameter("type");
		User user = extractUser(request);
		UserService userService = new UserService();
		
		if("changeUser".equals(type)){
			changeUser(request, response, session, user, userService);
		}else if("lookPersonal".equals(type)) {
			lookPersonal(request, response, session, user, userService);
		}
	}
	//修改个人信息
		private void changeUser(HttpServletRequest request,
				HttpServletResponse response, HttpSession session, User user,
				UserService userService) throws ServletException, IOException {
			
			boolean us=userService.changeUser(user);
			if(us){
				session.setAttribute("user", user);
				//更新信息成功
				response.sendRedirect("/pet/jsp/personal.jsp?change=true");
			}else {
				//更新信息失败
				response.sendRedirect("/pet/jsp/personal.jsp");
			}
			
		}
		//查看他人信息页面
		private void lookPersonal(HttpServletRequest request,
				HttpServletResponse response, HttpSession session, User user,
				UserService userService) throws ServletException, IOException {
			int user_id=Integer.valueOf(request.getParameter("user_id"));		
			user = userService.getUserById(user_id, false);		
			if(user != null){
				request.setAttribute("user", user);
				request.getRequestDispatcher("/jsp/lookPersonal.jsp").forward(request, response);
			}else{
				
				request.getRequestDispatcher("/PetController?type=petList").forward(request, response);
			}
			
		}
	
	private User extractUser(HttpServletRequest request) {
		User user = new User();
		//写入ID		
		HttpSession session=request.getSession();
		User user2=new User();
		user2=(User)session.getAttribute("user");
		if(user2!=null){
		user.setUserId(user2.getUserId());
		}
		//
		user.setUserName(request.getParameter("user_name") != null ? request.getParameter("user_name") : null );
		user.setUserPwd(request.getParameter("user_pwd") != null ? request.getParameter("user_pwd") : null );
		user.setUserSex(request.getParameter("user_sex") != null ? request.getParameter("user_sex") : null );
		user.setUserTel(request.getParameter("user_tel") != null ? request.getParameter("user_tel") : null );
		user.setUserAddress(request.getParameter("user_address") != null ? request.getParameter("user_address") : null );
		return user;
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
