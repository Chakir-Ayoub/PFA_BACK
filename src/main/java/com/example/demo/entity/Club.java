package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String idclub;
	@Column(nullable = false)
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "club",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Terrain> terrains;
	
	@JsonIgnore
	@OneToMany(mappedBy = "club",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Packe> packages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdclub() {
		return idclub;
	}

	public void setIdclub(String idclub) {
		this.idclub = idclub;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}

	public List<Packe> getPackages() {
		return packages;
	}

	public void setPackages(List<Packe> packages) {
		this.packages = packages;
	}
	
	
}
