package org.fjzzy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.Pet;
import org.fjzzy.domain.User;
import org.fjzzy.service.CommentService;
import org.fjzzy.service.PetService;
import org.fjzzy.util.FormUtil;
import org.fjzzy.util.PageBean;

public class PetController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PetService petService = new PetService();
		CommentService commentService = new CommentService();
		String type = request.getParameter("type");
		Pet pet = extractPet(request);
		
		if("petShow".equals(type)){
			petShow(request, response, petService, commentService, pet);
			
		}else if("petList".equals(type)){
			showPetList(request, response, petService);
		}else{
			if(session.getAttribute("user") != null){
				ServletContext servletContext = request.getServletContext();
				FormUtil.setBasePath(servletContext.getRealPath("/images")  + "\\");
				HashMap<String, Object> map = FormUtil.parserData(servletContext, request);
				addPet(request, response, session, petService, map);
			}else{
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		}
		
	}
	private void addPet(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			PetService petService, HashMap<String, Object> map)
			throws ServletException, IOException {
		Pet pet;
		if("addPet".equals(map.get("type"))){
			pet = getPet(map);
			User user = (User) session.getAttribute("user");
			pet.setPetUserId(user.getUserId());
			petService.addPet(pet);
			request.getRequestDispatcher("/PetController?type=petList").forward(request, response);
		}
	}
	private Pet getPet(HashMap<String, Object> map) {
		Pet pet = new Pet();
		pet.setPetUserId(map.get("pet_user_id") != null ? Integer.parseInt(map.get("pet_user_id").toString()) : -1);
		pet.setPetTitle(map.get("pet_title") != null ? map.get("pet_title").toString() : null);
		pet.setPetType((map.get("pet_type") != null ? Integer.parseInt(map.get("pet_type").toString()) : -1));
		pet.setPetIntrod(map.get("pet_introd") != null ? map.get("pet_introd").toString() : null);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) map.get("fileName");
		Iterator<String> it = list.iterator();
		int i = 0;
		while(it.hasNext()){
			String fileName = it.next();
			switch(i){
			case 0 : pet.setPetPic1(fileName);
			break;
			case 1 : pet.setPetPic2(fileName);
			break;
			case 2 : pet.setPetPic3(fileName);
			break;
			}
			i++;
		}
		return pet;
	}

	private void showPetList(HttpServletRequest request,
			HttpServletResponse response, PetService petService)
			throws ServletException, IOException {
		//设置pageBean
		PageBean pageBean = new PageBean(1);
		
		if(request.getParameter("pageNow") != null){
			pageBean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}
		
		List<Pet> list = petService.getListByPage(pageBean, true);
		request.setAttribute("petList", list);
		request.setAttribute("pageBean", pageBean);
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
