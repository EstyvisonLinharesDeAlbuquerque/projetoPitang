package com.pitang.treinamento.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

@Entity
@Table(name = "message")
public class MessageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Past
	@Size(max = 65)
	@Column(name = "date")
	private LocalDate date;
	
	@NotNull
	@Past
	@Size(max = 65)
	@Column(name = "hour")
	private LocalTime hour;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "message")
	private String message;
	/*
	@NotNull
	@Size(max = 65)
	@Column(name = "status_source")
	private boolean statusSource;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "status_destiny")
	private boolean statusDestiny;
	*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_source", referencedColumnName = "id")
	private UserModel source;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_destiny", referencedColumnName = "id")
	private Contact destiny;

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

	/*public boolean isStatusSource() {
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
*/
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
}
