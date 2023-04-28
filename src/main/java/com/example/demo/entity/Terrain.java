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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String terraiid;
	@Column(nullable = false,length = 50)
	private String nom;
	@Column(nullable = false,length = 50)
	private String adresse;
	@Column(nullable = false)
	private Float attitude ;
	@Column(nullable = false)
	private Float longitude ;
	@Column(nullable = false)
	private Integer Type;
	@Column(nullable = false)
	private Boolean etat=false;
	@Column(nullable = false,length = 50)
	private String descriptuon;
	@Column(nullable = false)
	private Float tarif;
	
	@JoinColumn(name = "id_zone",nullable = false)
	@ManyToOne
	private Zone zone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "terrain",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Photo> photo;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "terrain",cascade = CascadeType.ALL)
	private List<Occupation> occupations;
	
	@JoinColumn(name = "id_club",nullable = false)
	@ManyToOne
	private Club club;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTerraiid() {
		return terraiid;
	}

	public void setTerraiid(String terraiid) {
		this.terraiid = terraiid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Float getAttitude() {
		return attitude;
	}

	public void setAttitude(Float attitude) {
		this.attitude = attitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Integer getType() {
		return Type;
	}

	public void setType(Integer type) {
		Type = type;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getDescriptuon() {
		return descriptuon;
	}

	public void setDescriptuon(String descriptuon) {
		this.descriptuon = descriptuon;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	
}
