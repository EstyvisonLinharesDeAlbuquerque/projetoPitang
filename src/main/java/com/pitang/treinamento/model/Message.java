package com.pitang.treinamento.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "datetime")
	private Date datetime;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "message")
	private String message;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "message")
	private boolean statusSource;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "message")
	private boolean statusDestiny;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_userMessage")
	private UserModel source;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_contactMessage")
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
