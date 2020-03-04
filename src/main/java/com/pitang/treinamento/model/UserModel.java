package com.pitang.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class UserModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@NotNull
	@Size(max = 65)
	@Column(name = "name")
	private String name;

	@NotNull
	@Size(max = 65)
	@Column(name = "user_name")
	private String username;

	@NotNull
	@Size(max = 65)
	@Column(name = "email")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userModel", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Contact> contacts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "source", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<MessageModel> messages;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userSource", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Story> stories;
	
	
	/*
	public UserModel(String name, String username, String email, String password) {
		setName(name);
		setUsername(username);
		setEmail(email);
		setPassword(password);
	}
	*/
	public Long getId() {
		return idUser;
	}

	public void setId(Long idUser) {
		this.idUser = idUser;
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<MessageModel> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageModel> messages) {
		this.messages = messages;
	}
}