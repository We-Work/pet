package org.fjzzy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.Pet;
import org.fjzzy.service.CommentService;
import org.fjzzy.service.PetService;
import org.fjzzy.util.PageBean;

public class PetController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PetService petService = new PetService();
		CommentService commentService = new CommentService();
		String type = request.getParameter("type");
		Pet pet = extractPet(request);
		
		if("petShow".equals(type)){
			petShow(request, response, petService, commentService, pet);
			
		}else if("petList".equals(type)){
			showPetList(request, response, petService);
		}
		
	}



	private void showPetList(HttpServletRequest request,
			HttpServletResponse response, PetService petService)
			throws ServletException, IOException {
		PageBean pageBean = new PageBean();
		
		if(request.getParameter("pageNow") != null){
			pageBean.setPageCount(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}
		pageBean.setPageSize(10);
		List<Pet> list = petService.getListByPage(pageBean, true);
		request.setAttribute("petList", list);
		request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}



	private void petShow(HttpServletRequest request,
			HttpServletResponse response, PetService petService,
			CommentService commentService, Pet pet) throws ServletException,
			IOException {
		pet = petService.getPetById(pet.getPetId(), true);
		int id = pet.getPetId();
		List<Comment> com_list = commentService.getCommentsByPetId(id, true);
		request.setAttribute("com_list", com_list);
		request.setAttribute("pet", pet);
		request.getRequestDispatcher("/jsp/particulars.jsp").forward(request, response);;
	}



	private Pet extractPet(HttpServletRequest request) {
		Pet pet = new Pet();
		pet.setPetId(request.getParameter("pet_id") != null ? Integer.parseInt(request.getParameter("pet_id")) : -1);
		pet.setPetUserId(request.getParameter("pet_user_id") != null ? Integer.parseInt(request.getParameter("pet_user_id")) : -1);
		pet.setPetTitle(request.getParameter("pet_title") != null ? request.getParameter("pet_title") : null);
		pet.setPetType(request.getParameter("pet_type") != null ? Integer.parseInt(request.getParameter("pet_type")) : -1);
		pet.setPetIntrod(request.getParameter("pet_introd") != null ? request.getParameter("pet_introd") : null);
		pet.setPetState(request.getParameter("pet_state") != null ? Boolean.parseBoolean(request.getParameter("pet_state")) : false);
		pet.setPetCheck(request.getParameter("pet_check") != null ? Boolean.parseBoolean(request.getParameter("pet_check")) : false);
		pet.setPetPic1(request.getParameter("pet_pic1") != null ? request.getParameter("pet_pic1") : null);
		pet.setPetPic2(request.getParameter("pet_pic2") != null ? request.getParameter("pet_pic2") : null);
		pet.setPetPic2(request.getParameter("pet_pic2") != null ? request.getParameter("pet_pic3") : null);
		return pet;
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
