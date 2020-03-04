package com.pitang.treinamento.dto;

import java.time.LocalDateTime;

import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.UserModel;

public class MessageDto {
	private Long id;
	private LocalDateTime datetime;
	private String message;
	private UserModel source;
	private Contact destiny;
	private Boolean statusSource;
	private Boolean statusDestiny;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatetime() {
		return datetime;
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
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public Boolean getStatusSource() {
		return statusSource;
	}
	public void setStatusSource(Boolean statusSource) {
		this.statusSource = statusSource;
	}
	public Boolean getStatusDestiny() {
		return statusDestiny;
	}
	public void setStatusDestiny(Boolean statusDestiny) {
		this.statusDestiny = statusDestiny;
	}
}
