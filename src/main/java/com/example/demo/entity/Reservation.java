package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String idreservation;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(nullable = false)
	private Boolean etat=false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL)
	private List<Occupation> occupations;
	
	@JsonIgnore
	@ManyToOne
	private UserEntity clientid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public UserEntity getClientid() {
		return clientid;
	}

	public void setClientid(UserEntity clientid) {
		this.clientid = clientid;
	}
	
	
}
