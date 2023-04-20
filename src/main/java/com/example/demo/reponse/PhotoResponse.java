package com.example.demo.reponse;
import com.example.demo.entity.Terrain;


public class PhotoResponse {
	private String photoid;
	private String url;
	private Terrain terrain;
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
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	

	
	
	
	
}
