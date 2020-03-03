package com.pitang.treinamento.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "message")
public class MessageModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="source", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private UserModel source;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destiny", referencedColumnName = "id_userModel", nullable = false)
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

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
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
