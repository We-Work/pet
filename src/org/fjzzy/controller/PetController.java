package org.fjzzy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fjzzy.domain.Pet;
import org.fjzzy.service.PetService;
import org.fjzzy.util.PageBean;

public class PetController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PetService petService = new PetService();
		
		PageBean pageBean = new PageBean();
		if(request.getParameter("pageNow") != null){
			pageBean.setPageCount(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}
		pageBean.setPageSize(10);
		//pageBean.setRowCount(petService.getRowCount("select * from pet", null));
		List<Pet> list = petService.getListByPage(pageBean, true);
		request.setAttribute("petList", list);
		request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
