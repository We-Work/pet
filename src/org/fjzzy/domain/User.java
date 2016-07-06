package org.fjzzy.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String userSex;
	private String userTel;
	private String userAddress;
	
	//其他表中引用 User表主键(user_id)的在pojo中映射为List 对象
	//引用主键
	private List<Pet> petList = new ArrayList<Pet>();
	private List<Comment> commentList = new ArrayList<Comment>();
	private List<Reply> replyList = new ArrayList<Reply>();
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	public List<Pet> getPetList() {
		return petList;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserSex() {
		return userSex;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
}
