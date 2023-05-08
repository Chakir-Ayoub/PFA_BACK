package com.example.demo.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.shared.dto.ProprietaireDto;

public interface ProprietaireService extends UserDetailsService {
	
	ProprietaireDto createProprietaire(ProprietaireDto proprietaireDto);
	ProprietaireDto GetProprietaireById(String id);
	ProprietaireDto Update(String id,ProprietaireDto proprietaireDto);
	void Delete(String id);
	List<ProprietaireDto> getAllProprietaire();
	ProprietaireDto getUser(String email);
}
