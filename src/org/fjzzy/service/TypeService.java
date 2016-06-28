package org.fjzzy.service;

import java.util.ArrayList;
import java.util.List;

import org.fjzzy.domain.Type;
import org.fjzzy.util.SqlHelper;

public class TypeService extends AbstractService{
	private PetService petService = new PetService();
	
	//按type_id获取Type
	public Type getTypeById(java.io.Serializable id, boolean load){
		String sql = "select * from type where type_id = ?";
		Object[] paras = {id};
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		Type type = null;
		if(!list.isEmpty()){
			type = parserType(list.get(0));
			if(load){
				type.setPetList(petService.getPetListByType(type.getTypeId(), !load));
			}
		}
		return type;
	}
	
	//获取宠物类型类表
	public List<Type> getTypeList(){
		List<Type> typeList= new ArrayList<Type>();
		String sql = "select * from type";
		List<Object[]> list = SqlHelper.executeQuery(sql, null);
		for(Object[] obj : list){
			Type type = parserType(obj);
			typeList.add(type);
		}
		return typeList;
	}
	
	public Type parserType(Object[] obj){
		Type type = new Type();
		if(obj[0] != null){
			type.setTypeId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			type.setTypeName(obj[1].toString());
		}
		return type;
	}
}
