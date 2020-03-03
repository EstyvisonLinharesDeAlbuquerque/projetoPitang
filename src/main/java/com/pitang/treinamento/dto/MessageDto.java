package com.pitang.treinamento.dto;

import java.time.LocalDateTime;

public class MessageDto {
	private Long id;
	private LocalDateTime datetime;
	private String message;
	private Long idSource;
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
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
}
