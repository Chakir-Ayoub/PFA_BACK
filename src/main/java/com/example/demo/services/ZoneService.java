package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.VilleDto;
import com.example.demo.shared.dto.ZoneDto;

public interface ZoneService {
	 ZoneDto CreateZone(ZoneDto dto);
	 ZoneDto GetBynom(String id);
	 ZoneDto Update(String id,ZoneDto dto);
	 void Delete(String id);
	 List<ZoneDto> GetAllVille();
}
