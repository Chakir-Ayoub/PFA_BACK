package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.TerrainDTO;

public interface TerrainService {
	TerrainDTO CreateTerrain(TerrainDTO dto);
	List<TerrainDTO> GetAll();
	TerrainDTO Update(String id,TerrainDTO dto);
	void Delete(String id);
}
