package org.fjzzy.controller;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.util.SecurityCode;
import org.fjzzy.util.SecurityCodeFactory;

public class SecurityCodeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		HttpSession session = request.getSession();
		//操作类型
		String opt = request.getParameter("opt");
		opt = URLEncoder.encode(URLEncoder.encode(opt, "iso-8859-1"), "utf-8");
		
		if("create".equals(opt.trim())){
			//输出验证码
			SecurityCode securityCode = SecurityCodeFactory.getSecurityCode();
			response.getOutputStream().write(securityCode.getImgData());
			session.setAttribute("code", securityCode.getCode());
			securityCode = null;
		}else if("check".equals(opt.trim())){
			String code = request.getParameter("code");
			if (session.getAttribute("code").toString().equals(code)) {
				response.getWriter().print("success");
			}else{
				response.getWriter().print("fail");
			}
		}
		
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
