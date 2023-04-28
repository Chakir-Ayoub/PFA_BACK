package com.example.demo.shared.dto;

import java.util.Date;

import com.example.demo.entity.UserEntity;

public class ReservationDTO {
	private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
