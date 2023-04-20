package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Club;
import com.example.demo.repositorys.ClubRepository;
import com.example.demo.services.ClubService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.ClubDTO;

@Service
public class ClubServiceImpl implements ClubService {
	@Autowired 
	ClubRepository clubRepository;
	@Autowired
	Utils utils;
	@Override
	public ClubDTO CreateClub(ClubDTO clubDTO) {
		// TODO Auto-generated method stub
		Club check=clubRepository.findBynom(clubDTO.getNom());
		if(check!=null) throw new RuntimeException("Already Exists");
		
		Club club=new Club();
		BeanUtils.copyProperties(clubDTO, club);
		
		club.setIdclub(utils.generateStringId(32));
		
		Club createclub=clubRepository.save(club);
		ClubDTO clubDTO2=new ClubDTO();
		
		BeanUtils.copyProperties(createclub, clubDTO2);
		return clubDTO2;
	}

	@Override
	public List<ClubDTO> GetAll() {
		// TODO Auto-generated method stubt
		List<ClubDTO> clubDTOs=new ArrayList<>();
		List<Club> clubs=clubRepository.findAll();
		
		for (Club club : clubs) {
			ClubDTO dto=new ClubDTO();
			BeanUtils.copyProperties(club, dto);
			
			clubDTOs.add(dto);
		}
		return clubDTOs;
	}

	@Override
	public ClubDTO Update(String id, ClubDTO clubDTO) {
		// TODO Auto-generated method stub
		Club club=clubRepository.findByidclub(id);
		if(club==null) throw new RuntimeException("Not Exists");
		
		club.setNom(clubDTO.getNom());
		
		Club updateclub=clubRepository.save(club);
		ClubDTO clubDTO2=new ClubDTO();
		
		BeanUtils.copyProperties(updateclub, clubDTO2);
		return clubDTO2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Club club=clubRepository.findByidclub(id);
		if(club==null) throw new RuntimeException("Not Exists");
		
		clubRepository.delete(club);
	}

	@Override
	public ClubDTO GetClubBynom(String nom) {
		// TODO Auto-generated method stub
		Club club=clubRepository.findBynom(nom);
		if(club==null) throw new RuntimeException("Not Exists");
		ClubDTO clubDTO=new ClubDTO();
		BeanUtils.copyProperties(club, clubDTO);
		return clubDTO;
	}

}
