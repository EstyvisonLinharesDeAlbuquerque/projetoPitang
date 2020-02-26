package com.pitang.treinamento.dto;

import java.util.Date;

import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.UserModel;

public class MessageDto {
	private Long id;
	private Date datetime;
	private String message;
	private boolean statusSource;
	private boolean statusDestiny;
	private UserModel source;
	private Contact destiny;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatusSource() {
		return statusSource;
	}
	public void setStatusSource(boolean statusSource) {
		this.statusSource = statusSource;
	}
	public boolean isStatusDestiny() {
		return statusDestiny;
	}
	public void setStatusDestiny(boolean statusDestiny) {
		this.statusDestiny = statusDestiny;
	}
	public UserModel getSource() {
		return source;
	}
	public void setSource(UserModel source) {
		this.source = source;
	}
	public Contact getDestiny() {
		return destiny;
	}
	public void setDestiny(Contact destiny) {
		this.destiny = destiny;
	}
}
