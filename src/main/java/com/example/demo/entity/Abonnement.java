package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Abonnement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 50)
	private String idabonnement;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JoinColumn(name = "id_client",nullable = false)
	@ManyToOne
	private UserEntity client;
	
	@JoinColumn(name = "id_packe",nullable = false)
	@ManyToOne
	private Packe packe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdabonnement() {
		return idabonnement;
	}

	public void setIdabonnement(String idabonnement) {
		this.idabonnement = idabonnement;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserEntity getClient() {
		return client;
	}

	public void setClient(UserEntity client) {
		this.client = client;
	}

	public Packe getPacke() {
		return packe;
	}

	public void setPacke(Packe packe) {
		this.packe = packe;
	}
	
	
}
