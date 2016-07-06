package org.fjzzy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fjzzy.domain.Pet;
import org.fjzzy.util.FormUtil;

public class TestController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext servletContext = this.getServletConfig().getServletContext();
		String path = servletContext.getRealPath("/images/");
		FormUtil.setBasePath(path);
		HashMap<String, Object> map = FormUtil.parserData(servletContext, request);
		
		
		Set<Entry<String, Object>> set = map.entrySet();
		Iterator<Entry<String, Object>> it1 = set.iterator();
		while(it1.hasNext()){
			Entry<String, Object> entry = it1.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		
		
		Pet pet = getPet(map);
		pet.getPetDate();
	}

	private Pet getPet(HashMap<String, Object> map) {
		Pet pet = new Pet();
		pet.setPetTitle(map.get("pet_title") != null ? map.get("pet_title").toString() : null);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
