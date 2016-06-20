package org.fjzzy.service;

import java.util.ArrayList;
import java.util.List;

import org.fjzzy.domain.Pet;
import org.fjzzy.util.PageBean;
import org.fjzzy.util.SqlHelper;

public class PetService extends AbstractService{
	
	//UserService 对象用于获取 Pet对象的创造者
	private static UserService userService = new UserService();
	private static TypeService typeService = new TypeService();
	private static CommentService commentService = new CommentService();
	//展示宠物信息
	public ArrayList<Pet> getListByPage(PageBean pageBean, boolean load){
		ArrayList<Pet> petList = new ArrayList<Pet>();
		String sql = "select * from Pet limit ?,?";
		Object[] paras = {(pageBean.getPageNow()-1)*pageBean.getPageSize(), 
				pageBean.getPageSize()};
		pageBean.setRowCount(this.getRowCount("select count(*) from pet", null));
		int pageCount = (pageBean.getRowCount()-1) / pageBean.getPageSize() + 1;
		pageBean.setPageCount(pageCount);
		@SuppressWarnings("unchecked")
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		for(Object[] obj : list){
			Pet pet = parserPet(obj);
			if(load){
				pet.setUser(userService.getUserById(pet.getPetUserId(), !load));
				pet.setType(typeService.getTypeById(pet.getPetType(), !load));
				pet.setCommentList(commentService.getCommentsByPetId(pet.getPetId(), !load));
			}
			petList.add(pet);
		}
		return petList;
	}
	
	
	public ArrayList<Pet> getPetListByType(java.io.Serializable id, boolean load){
		ArrayList<Pet> petList = new ArrayList<Pet>();
		String sql = "select * from Pet where pet_type = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		for(Object[] obj : list){
			Pet pet = parserPet(obj);
			if(load){
				pet.setUser(userService.getUserById(pet.getPetUserId(), !load));
				pet.setType(typeService.getTypeById(pet.getPetType(), !load));
				pet.setCommentList(commentService.getCommentsByPetId(pet.getPetId(), !load));
			}
			petList.add(pet);
		}
		return petList;
	}
	
	//按petId查找宠物
	public Pet getPetById(java.io.Serializable id, boolean load){
		String sql = "select * from pet where pet_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		Pet pet = null;
		if(!list.isEmpty()){
			pet = parserPet(list.get(0));
			if(load){
				pet.setUser(userService.getUserById(pet.getPetUserId(), !load));
				pet.setType(typeService.getTypeById(pet.getPetType(), !load));
				pet.setCommentList(commentService.getCommentsByPetId(pet.getPetId(), !load));
			}
		}
		return pet;
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
		String sql = "insert into Pet(pet_user_id,pet_title,pet_type,pet_introd,"
				+ "pet_pic1,pet_pic2,pet_pic3) values(?,?,?,?,?,?,?)";
		Object[] paras = {pet.getPetUserId(), pet.getPetTitle(), pet.getPetType(), pet.getPetIntrod(), 
				pet.getPetPic1(), pet.getPetPic2(), pet.getPetPic3()};
		int i = SqlHelper.executeUpdate(sql, paras);
		if(i == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//数据库关系对象模式转 java 对象
	public Pet parserPet(Object[] obj) {
		Pet pet = new Pet();
		if(obj[0] != null){
			pet.setPetId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			pet.setPetUserId(Integer.parseInt(obj[1].toString()));
		}
		if(obj[2] != null){
			pet.setPetTitle(obj[2].toString());
		}
		if(obj[3] != null){
			pet.setPetType(Integer.parseInt(obj[3].toString()));
		}
		if(obj[4] != null){
			pet.setPetDate((java.sql.Timestamp)obj[4]);
		}
		if(obj[5] != null){
			pet.setPetIntrod(obj[5].toString());
		}
		if(obj[6] != null){
			pet.setPetState(Boolean.parseBoolean((obj[6].toString())));
		}
		if(obj[7] != null){
			pet.setPetCheck(Boolean.parseBoolean((obj[7].toString())));
		}
		if(obj[8] != null){
			pet.setPetPic1(obj[8].toString());
		}
		if(obj[9] != null){
			pet.setPetPic2(obj[9].toString());
		}
		if(obj[10] != null){
			pet.setPetPic3(obj[10].toString());
		}
		return pet;
	}
}
