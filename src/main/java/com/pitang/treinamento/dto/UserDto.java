package com.pitang.treinamento.dto;

import java.util.List;

import com.pitang.treinamento.model.Contact;
import com.pitang.treinamento.model.MessageModel;
import com.pitang.treinamento.model.Story;

public class UserDto {
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private List<Contact> contacts;
	private List<MessageModel> messages;
	private List<Story> story;
	
	public List<Story> getStory() {
		return story;
	}
	public void setStory(List<Story> story) {
		this.story = story;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<MessageModel> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageModel> messages) {
		this.messages = messages;
	}
}