package com.example.demo.reponse;

import java.util.Date;

import com.example.demo.entity.UserEntity;

public class ReservationRequest {
	private String idreservation;
	private Date date;
	private Boolean etat=false;
	private UserEntity clientid;
	
	public String getIdreservation() {
		return idreservation;
	}
	public void setIdreservation(String idreservation) {
		this.idreservation = idreservation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public UserEntity getClientid() {
		return clientid;
	}
	public void setClientid(UserEntity clientid) {
		this.clientid = clientid;
	}

}
