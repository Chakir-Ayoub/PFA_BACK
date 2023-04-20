package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.ClubDTO;

public interface ClubService {
	ClubDTO CreateClub(ClubDTO clubDTO);
	List<ClubDTO> GetAll();
	ClubDTO Update(String id,ClubDTO clubDTO);
	void Delete(String id);
	ClubDTO GetClubBynom(String nom);
}
