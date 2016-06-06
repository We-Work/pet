package org.fjzzy.domain;
import java.sql.*;
public class Pet {
	private int petId;
	private String petTitle;
	private int petType;
	private Timestamp petDate;
	private String petIntrod;
	private boolean petState;
	private boolean petCheck;
	private String petPic1;
	private String petPic2;
	private String petPic3;
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetTitle() {
		return petTitle;
	}
	public void setPetTitle(String petTitle) {
		this.petTitle = petTitle;
	}
	public int getPetType() {
		return petType;
	}
	public void setPetType(int petType) {
		this.petType = petType;
	}
	public Timestamp getPetDate() {
		return petDate;
	}
	public void setPetDate(Timestamp petDate) {
		this.petDate = petDate;
	}
	public String getPetIntrod() {
		return petIntrod;
	}
	public void setPetIntrod(String petIntrod) {
		this.petIntrod = petIntrod;
	}
	public boolean isPetState() {
		return petState;
	}
	public void setPetState(boolean petState) {
		this.petState = petState;
	}
	public boolean isPetCheck() {
		return petCheck;
	}
	public void setPetCheck(boolean petCheck) {
		this.petCheck = petCheck;
	}
	public String getPetPic1() {
		return petPic1;
	}
	public void setPetPic1(String petPic1) {
		this.petPic1 = petPic1;
	}
	public String getPetPic2() {
		return petPic2;
	}
	public void setPetPic2(String petPic2) {
		this.petPic2 = petPic2;
	}
	public String getPetPic3() {
		return petPic3;
	}
	public void setPetPic3(String petPic3) {
		this.petPic3 = petPic3;
	}
}
