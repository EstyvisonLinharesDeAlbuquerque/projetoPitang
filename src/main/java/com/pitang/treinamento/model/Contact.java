package com.pitang.treinamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "fone")
	private String fone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_userModel", referencedColumnName = "id")
	@JsonIgnore
	private UserModel userModel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "destiny")
	@JsonIgnore
	private List<MessageModel> contactMessage;
	
	public List<MessageModel> getContactMessage() {
		return contactMessage;
	}

	public void setContactMessage(List<MessageModel> message) {
		this.contactMessage = message;
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

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}