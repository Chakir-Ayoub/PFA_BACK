package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Occupation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String idoccupation;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date heure;
	
	@JoinColumn(name = "idterrain",nullable = false)
	@ManyToOne
	private Terrain terrain;
	
	
	@JoinColumn(name = "idreservation",nullable = false)
	@ManyToOne
	private Reservation reservation;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getIdoccupation() {
		return idoccupation;
	}


	public void setIdoccupation(String idoccupation) {
		this.idoccupation = idoccupation;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getHeure() {
		return heure;
	}


	public void setHeure(Date heure) {
		this.heure = heure;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
}
