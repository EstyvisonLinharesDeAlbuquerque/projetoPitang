package com.pitang.treinamento.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;

@Entity
@Table(name = "message")
public class MessageModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "datetime")
	private LocalDateTime datetime;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "msg")
	private String message;
	
	@NotNull
	@Column(name = "source")
	private Long idSource;
	
	@NotNull
	@Column(name = "destiny")
	private Long idDestiny;

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

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Long getIdSource() {
		return idSource;
	}

	public void setIdSource(Long idSource) {
		this.idSource = idSource;
	}

	public Long getIdDestiny() {
		return idDestiny;
	}

	public void setIdDestiny(Long idDestiny) {
		this.idDestiny = idDestiny;
	}
}
