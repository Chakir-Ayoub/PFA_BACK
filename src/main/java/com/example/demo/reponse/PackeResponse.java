package com.example.demo.reponse;

import com.example.demo.entity.Club;


public class PackeResponse {
	private Integer id;
	private String idpacke;
	private String nom;
	private Float tarif;
	private Integer nbr_match;
	private Club club;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdpacke() {
		return idpacke;
	}
	public void setIdpacke(String idpacke) {
		this.idpacke = idpacke;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getTarif() {
		return tarif;
	}
	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}
	public Integer getNbr_match() {
		return nbr_match;
	}
	public void setNbr_match(Integer nbr_match) {
		this.nbr_match = nbr_match;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	
	
}
