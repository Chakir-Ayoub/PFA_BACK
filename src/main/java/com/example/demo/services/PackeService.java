package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.PackeDTO;

public interface PackeService {
	PackeDTO createPacke(PackeDTO dto);
	PackeDTO Update(String id,PackeDTO dto);
	void Delete(String id);
	List<PackeDTO> getAll();
}
