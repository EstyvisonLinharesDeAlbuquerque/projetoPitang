package com.pitang.treinamento.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.UserModel;

public class StoryDto {

	private Long id;
	private LocalDateTime datetime;
	private String message;
	private UserModel userSource;
	private Boolean status;
	private List<Contact> views;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserModel getUserSource() {
		return userSource;
	}
	public void setUserSource(UserModel userSource) {
		this.userSource = userSource;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public List<Contact> getViews() {
		return views;
	}
	public void setViews(List<Contact> views) {
		this.views = views;
	}
}
