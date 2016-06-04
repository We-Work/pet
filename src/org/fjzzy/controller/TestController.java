package org.fjzzy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fjzzy.util.SecurityCode;
import org.fjzzy.util.SecurityCodeFactory;

public class TestController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getRemoteAddr());
		SecurityCode securityCode = SecurityCodeFactory.getSecurityCode();
		response.getOutputStream().write(securityCode.getImgData());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
