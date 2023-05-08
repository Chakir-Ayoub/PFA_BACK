package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.ProprietaireDto;

public interface ProprietaireService {
	
	ProprietaireDto createProprietaire(ProprietaireDto proprietaireDto);
	ProprietaireDto GetProprietaireById(String id);
	ProprietaireDto Update(String id,ProprietaireDto proprietaireDto);
	void Delete(String id);
	List<ProprietaireDto> getAllProprietaire();
	ProprietaireDto getUser(String email);
}
