package org.fjzzy.domain;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Pet {
	private int petId;
	private int petUserId;
	private String petTitle;
	private int petType;
	private Timestamp petDate;
	private String petIntrod;
	private boolean petState;
	private boolean petCheck;
	private String petPic1;
	private String petPic2;
	private String petPic3;
	//引用外键
	private User user;
	private Type type;
	//引用主键
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	public Timestamp getPetDate() {
		return petDate;
	}
	public int getPetId() {
		return petId;
	}
	public String getPetIntrod() {
		return petIntrod;
	}
	public String getPetPic1() {
		return petPic1;
	}
	public String getPetPic2() {
		return petPic2;
	}
	public String getPetPic3() {
		return petPic3;
	}
	public String getPetTitle() {
		return petTitle;
	}
	public int getPetType() {
		return petType;
	}
	public int getPetUserId() {
		return petUserId;
	}
	public User getUser() {
		return user;
	}
	public boolean isPetCheck() {
		return petCheck;
	}
	public boolean isPetState() {
		return petState;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setPetCheck(boolean petCheck) {
		this.petCheck = petCheck;
	}
	public void setPetDate(Timestamp petDate) {
		this.petDate = petDate;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public void setPetIntrod(String petIntrod) {
		this.petIntrod = petIntrod;
	}
	public void setPetPic1(String petPic1) {
		this.petPic1 = petPic1;
	}
	public void setPetPic2(String petPic2) {
		this.petPic2 = petPic2;
	}
	public void setPetPic3(String petPic3) {
		this.petPic3 = petPic3;
	}
	public void setPetState(boolean petState) {
		this.petState = petState;
	}
	public void setPetTitle(String petTitle) {
		this.petTitle = petTitle;
	}
	public void setPetType(int petType) {
		this.petType = petType;
	}
	public void setPetUserId(int petUserId) {
		this.petUserId = petUserId;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
