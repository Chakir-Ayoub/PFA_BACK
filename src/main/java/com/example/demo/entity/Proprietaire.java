package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Proprietaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false,length = 50)
	private String proprietaireid;
	@Column(nullable = false,length = 50)
	private String firstName;
	@Column(nullable = false,length = 50)
	private String lastName;
	@Column(nullable = false,length = 50)
	private String email;
	@Column(nullable = false,length = 50)
	private String encryptedPassword;
	@Column(nullable = false)
	private Boolean admin;
	
	@OneToMany(mappedBy = "proprietaire",cascade = CascadeType.ALL)
	private List<Terrain> terrains;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}



	public String getProprietaireid() {
		return proprietaireid;
	}

	public void setProprietaireid(String proprietaireid) {
		this.proprietaireid = proprietaireid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}
	
	
	
	
}
