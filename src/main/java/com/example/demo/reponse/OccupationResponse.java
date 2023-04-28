package com.example.demo.reponse;

import java.util.Date;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Terrain;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class OccupationResponse {
	private String idoccupation;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date heure;
	private Terrain terrain;
	private Reservation reservation;
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
