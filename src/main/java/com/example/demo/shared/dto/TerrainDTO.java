package com.example.demo.shared.dto;

import com.example.demo.entity.Club;
import com.example.demo.entity.Zone;

public class TerrainDTO {
	private Integer id;
	private String terraiid;
	private String nom;
	private String adresse;
	private Float attitude ;
	private Float longitude ;
	private Integer Type;
	private Boolean etat=false;
	private String descriptuon;
	private Float tarif;
	private Zone zone;
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
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
}
