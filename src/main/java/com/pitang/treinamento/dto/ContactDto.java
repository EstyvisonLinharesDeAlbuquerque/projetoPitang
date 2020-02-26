package com.pitang.treinamento.dto;

import java.util.List;

import com.pitang.treinamento.model.*;

public class ContactDto {
	private Long id;
	private String name;
	private String fone;
	private UserModel userModel;
	private List<MessageModel> contactMessage; 
	
	public List<MessageModel> getContactMessage() {
		return contactMessage;
	}
	public void setContactMessage(List<MessageModel> message) {
		this.contactMessage = message;
	}
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
