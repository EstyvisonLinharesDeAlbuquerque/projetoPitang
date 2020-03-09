package com.pitang.treinamento.model;
import java.io.Serializable;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "profileImage")
public class ProfileImageModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Column(name = "image")
    @Lob
    private byte[] image;
    
    public ProfileImageModel() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
