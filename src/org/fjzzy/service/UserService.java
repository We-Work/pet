package org.fjzzy.service;

import java.util.ArrayList;
import java.util.List;

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
	
	//验证用户是否合法
	public User checkUser(User user){
		String sql = "select * from user where user_name=? and user_pwd=?";
		Object[] paras = {user.getUserName(), user.getUserPwd()};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		if(!list.isEmpty()){
			return parserUser(list.get(0));
		}
		return null;
	}
	
	/**
	 * 检查用户名是否可用
	 * 可用返回字符传"enable"否则"disable"
	 */
	public String checkUserName(User user){
		String sql = "select * from user where user_name=?";
		Object[] paras = {user.getUserName()};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		if(!list.isEmpty()){
			return "disable";
		}else{
			return "enable";
		}
	}
	
	//添加一个用户
	public boolean addUser(User user){
		String sql = "insert into  user (user_name ,user_pwd ,user_sex ,user_tel ,user_address ) "
				+ "values(?, ?, ?, ?, ?)";
		Object[] paras = {user.getUserName(), user.getUserPwd(), user.getUserSex(),
				user.getUserTel(), user.getUserAddress()};
		return SqlHelper.executeUpdate(sql, paras) == 1 ? true : false;
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
