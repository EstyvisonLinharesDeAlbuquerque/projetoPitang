package com.pitang.treinamento.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	public String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userModel")
	@JsonIgnore
	private List<Contact> contacts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userMessage")
	private List<String> message;
	
	/*
	public UserModel(String name, String username, String email, String password) {
		setName(name);
		setUsername(username);
		setEmail(email);
		setPassword(password);
	}
	*/
	public Long getId() {
		return id;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
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

	

	

	
}