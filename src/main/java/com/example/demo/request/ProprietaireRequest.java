package com.example.demo.request;

import java.util.List;

import com.example.demo.entity.Terrain;



public class ProprietaireRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Boolean admin;
	private List<TerrainRequest> terrains;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public List<TerrainRequest> getTerrains() {
		return terrains;
	}
	public void setTerrains(List<TerrainRequest> terrains) {
		this.terrains = terrains;
	}
	
	
}
