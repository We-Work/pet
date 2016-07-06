package org.fjzzy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fjzzy.domain.Type;
import org.fjzzy.service.TypeService;

public class TypeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		TypeService typeService = new TypeService();
		String type = request.getParameter("type");
		if("initAddPet".equals(type)){
			List<Type> list = typeService.getTypeList();
			request.setAttribute("typeList", list);
			request.getRequestDispatcher("/jsp/upload.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
