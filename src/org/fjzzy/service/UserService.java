package org.fjzzy.service;

import java.util.ArrayList;

import org.fjzzy.domain.User;
import org.fjzzy.util.SqlHelper;

public class UserService extends AbstractService{
	//按Id获取一个User对象
	public User getUserById(java.io.Serializable id, boolean load){
		String sql = "select * from User where user_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		return parserUser(list.get(0));
	}
	
	//将数据库关系对象模型转为java对象模型
	public User parserUser(Object[] obj){
		User user = new User();
		if(obj[0] != null){
			user.setUserId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			user.setUserName(obj[1].toString());
		}
		if(obj[2] != null){
			user.setUserPwd(obj[2].toString());
		}
		if(obj[3] != null){
			user.setUserSex(obj[3].toString());
		}
		if(obj[4] != null){
			user.setUserTel(obj[4].toString());
		}
		if(obj[5] != null){
			user.setUserAddress(obj[5].toString());
		}
		return user;
	}
}
