package org.fjzzy.service;

import java.util.ArrayList;
import org.fjzzy.domain.Pet;
import org.fjzzy.util.PageBean;
import org.fjzzy.util.SqlHelper;

public class PetService extends AbstractService{
	//展示宠物信息
	public ArrayList<Pet> getListByPage(PageBean pageBean){
		ArrayList<Pet> petList = new ArrayList<Pet>();
		String sql = "select * from Pet limit ?,?";
		String[] paras = {pageBean.getPageNow()+"", 
				((pageBean.getPageNow()-1)*pageBean.getPageSize()+1)+""};
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		for(Object[] obj : list){
			Pet pet = new Pet();
			parserPet(obj, pet);
			petList.add(pet);
		}
		return petList;
	}
	//删除宠物信息
	public boolean delPet(Pet pet){
		String sql="Delete from Pet where pet_id=?";
		String[] paras={pet.getPetId()+""};
		int i = SqlHelper.executeUpdate(sql, paras);
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}
	
	//增加一条宠物信息
	public boolean addPet(Pet pet){
		String sql = "insert into Pet(pet_title,pet_type,pet_date,pet_introd,"
				+ "pet_state,pet_check,pet_pic1,pet_pic2,pet_pic3) values(?,?,?,"
				+ "?,?,?,?,?)";
		String[] paras = {pet.getPetTitle(), pet.getPetType()+"", pet.getPetDate().toString(),
				pet.getPetIntrod(), Boolean.toString(pet.isPetState()), 
				Boolean.toString(pet.isPetCheck()), pet.getPetPic1(), pet.getPetPic2(),
				pet.getPetPic3()};
		int i = SqlHelper.executeUpdate(sql, paras);
		if(i == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//数据库关系对象模式转 java 对象
	public void parserPet(Object[] obj, Pet pet) {
		if(obj[0] != null){
			pet.setPetId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			pet.setPetTitle(obj[1].toString());
		}
		if(obj[2] != null){
			pet.setPetType(Integer.parseInt(obj[2].toString()));
		}
		if(obj[3] != null){
			pet.setPetDate((java.sql.Timestamp)obj[3]);
		}
		if(obj[4] != null){
			pet.setPetIntrod(obj[4].toString());
		}
		if(obj[5] != null){
			pet.setPetState(Boolean.parseBoolean((obj[5].toString())));
		}
		if(obj[6] != null){
			pet.setPetCheck(Boolean.parseBoolean((obj[6].toString())));
		}
		if(obj[7] != null){
			pet.setPetPic1(obj[7].toString());
		}
		if(obj[8] != null){
			pet.setPetPic2(obj[8].toString());
		}
		if(obj[9] != null){
			pet.setPetPic3(obj[9].toString());
		}
	}
}
