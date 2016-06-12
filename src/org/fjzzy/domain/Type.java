package org.fjzzy.domain;

import java.util.ArrayList;
import java.util.List;

public class Type {
	private int typeId;
	private String typeName;
	
	private List<Pet> petList = new ArrayList<Pet>();
	
	public int getTypeId() {
		return typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public List<Pet> getPetList() {
		return petList;
	}
	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
