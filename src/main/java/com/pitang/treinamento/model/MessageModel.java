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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@Size(max = 200)
	@Column(name = "msg")
	private String message;
	
	@NotNull
	@Column(name = "status_source")
	private Boolean statusSource;
	
	@NotNull
	@Column(name = "status_destiny")
	private Boolean statusDestiny;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="source", referencedColumnName = "idUser", nullable = false)
	@JsonIgnore
	private UserModel source;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destiny", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

	public Boolean getStatusSource() {
		return statusSource;
	}

	public void setStatusSource(Boolean statusSource) {
		this.statusSource = statusSource;
	}

	public Boolean getStatusDestiny() {
		return statusDestiny;
	}

	public void setStatusDestiny(Boolean statusDestiny) {
		this.statusDestiny = statusDestiny;
	}
}
