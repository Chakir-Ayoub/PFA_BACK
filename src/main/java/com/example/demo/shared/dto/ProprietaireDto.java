package com.example.demo.shared.dto;

import java.util.List;



public class ProprietaireDto {
	private Long Id;
	private String proprietaireid;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String password;
	private Boolean admin;
	private List<TerrainDTO> terrains;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public List<TerrainDTO> getTerrains() {
		return terrains;
	}
	public void setTerrains(List<TerrainDTO> terrains) {
		this.terrains = terrains;
	}

	
	
}
