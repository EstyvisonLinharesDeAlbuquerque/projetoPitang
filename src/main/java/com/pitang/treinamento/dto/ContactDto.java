package com.pitang.treinamento.dto;

import com.pitang.treinamento.model.*;

public class ContactDto {
	private Long id;
	private String name;
	private String fone;
	private UserModel userModel; 
	
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel user) {
		this.userModel = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
}
