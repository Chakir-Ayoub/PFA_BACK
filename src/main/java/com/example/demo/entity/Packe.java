package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Packe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String idpacke;
	@Column(nullable = false,length = 50)
	private String nom;
	@Column(nullable = false)
	private Float tarif;
	@Column(nullable = false)
	private Integer nbr_match;
	
	@JoinColumn(name="id_club")
	@ManyToOne
	private Club club;
	
	@JsonIgnore
	@OneToMany(mappedBy = "packe")
	private List<Abonnement> abonnements;

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

	public List<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(List<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}
	
	
}
