package com.example.demo.request;

import java.util.Date;
import com.example.demo.entity.UserEntity;


public class ReservationRequest {
	private Date date;
	private Boolean etat=false;
	private UserEntity clientid;
	
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
