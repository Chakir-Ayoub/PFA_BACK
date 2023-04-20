package com.example.demo.request;

import com.example.demo.entity.Terrain;


public class PhotoRequest {

	private String url;
	private Terrain terrain;
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
