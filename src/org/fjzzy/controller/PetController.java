package org.fjzzy.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.fjzzy.util.PetState;

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
		int state = (request.getParameter("state") != null ? Integer.parseInt(request.getParameter("state")) : -1);
		Pet pet = extractPet(request);
		
		if("petShow".equals(type)){
			petShow(request, response, petService, commentService, pet);
			
		}else if("userShowPetList".equals(type)) {
			userShowPetList(request, response, petService);			
		}else if("petList".equals(type)){
			showPetList(request, response, petService, state);
		}else if("adminRelease".equals(type)){
			//未审核帖子
			showAdminPet(request, response, session, petService,PetState.UNCHECK,"/jsp/adminRelease.jsp");
		}else if("adminPet".equals(type)){
			//已审核帖子
			showAdminPet(request, response, session, petService,PetState.CHECK,"/jsp/adminPet.jsp");
		}else if("deletePet".equals(type)){
			//删除宠物帖子
			delPet(request, response, session, petService, pet);
		}else if("releasePet".equals(type)){
			//审核宠物帖子
			releasePet(request, response, session, petService, pet);
		}
		else{
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
	private void releasePet(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			PetService petService, Pet pet) throws ServletException,
			IOException {
		if(session.getAttribute("admin") != null){
			boolean isCheck = petService.modifyPetState(pet);
			if(isCheck){
				showAdminPet(request, response, session, petService,PetState.CHECK,"/jsp/adminPet.jsp");
			}
		}
	}
	private void delPet(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			PetService petService, Pet pet) throws ServletException,
			IOException {
		if(session.getAttribute("admin") != null){
			boolean isDelPet = petService.delPet(pet);
			if(isDelPet){
				showAdminPet(request, response, session, petService,PetState.CHECK,"/jsp/adminPet.jsp");
			}
		}
	}
	private void showAdminPet(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			PetService petService,int state,String url) throws ServletException, IOException {
		if(session.getAttribute("admin") != null){
			PageBean pagebean = new PageBean(10);
			if(request.getParameter("pageNow") != null){
				pagebean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
			}else{
				pagebean.setPageNow(1);
			}
			ArrayList arraylist = petService.getListByPage(pagebean, true, state);
			request.setAttribute("petList", arraylist);
			request.setAttribute("pageBean", pagebean);
			request.getRequestDispatcher(url).forward(request, response);
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
			request.getRequestDispatcher("/PetController?type=petList&state=1").forward(request, response);
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
			HttpServletResponse response, PetService petService, int state)
			throws ServletException, IOException {
		//设置pageBean
		PageBean pageBean = new PageBean(10);
		
		if(request.getParameter("pageNow") != null){
			pageBean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}
		List<Pet> list = petService.getListByPage(pageBean, true, state);
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
	
//显示个人帖子
	private void userShowPetList(HttpServletRequest request,
			HttpServletResponse response, PetService petService)
			throws ServletException, IOException {
		//设置pageBean
		PageBean pageBean = new PageBean(10);
		HttpSession session=request.getSession();
		User user=new User();
		user=(User)session.getAttribute("user");
		if(request.getParameter("pageNow") != null){
			pageBean.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
		}else{
			pageBean.setPageNow(1);
		}		
		List<Pet> list = petService.getUserListByPage(user, pageBean, true);
		request.setAttribute("petUserList", list);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/jsp/userPost.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
