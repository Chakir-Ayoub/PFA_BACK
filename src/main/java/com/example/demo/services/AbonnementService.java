package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.AbonnementDTO;

public interface AbonnementService {
	AbonnementDTO CreateAonnement(AbonnementDTO abonnementDTO);
	List<AbonnementDTO> GetAll();
	AbonnementDTO UpdateAonnement(String id,AbonnementDTO abonnementDTO);
	void Delete(String id);
	
}
