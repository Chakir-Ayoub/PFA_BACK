package com.example.demo.entity;



import jakarta.persistence.*;


@Entity
public class Photo  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String photoid;
	@Column(nullable = false,length = 90)
	private String url;
	
	@JoinColumn(name = "id_terrain",nullable = false)
	@ManyToOne
	private Terrain terrain;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	public String getPhotoid() {
		return photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	
	
}
