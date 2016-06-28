package org.fjzzy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.User;
import org.fjzzy.service.UserService;

public class AuthenController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 验证控制器
	 * 处理用户登录,注册,忘记密码操作
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//用户判断用户操作请求
		String type = request.getParameter("type");
		User user = extractUser(request);
		UserService userService = new UserService();
		
		if("login".equals(type)){
			login(request, response, session, user, userService);
		}else if("register".equals(type)){
			userService.addUser(user);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}else if("checkName".equals(type)){
			response.getWriter().print(userService.checkUserName(user));
		}else if("findPwd".equals(type)){
			userService.findPwd(user);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}else if("checkTel".equals(type)){
			String rs = userService.checkTel(user);
			response.getWriter().print(rs);
		}
	}

	//登录处理
	private void login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, User user,
			UserService userService) throws ServletException, IOException {
		user = userService.checkUser(user);
		if(user != null){
			session.setAttribute("user", user);
			request.getRequestDispatcher("/PetController?type=petList").forward(request, response);
		}else{
			//用户不合法
			response.sendRedirect("/pet/jsp/login.jsp?loginError=error");
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
