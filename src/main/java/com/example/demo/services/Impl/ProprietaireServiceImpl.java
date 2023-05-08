package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proprietaire;
import com.example.demo.repositorys.ProprietaireRepository;
import com.example.demo.services.ProprietaireService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.ProprietaireDto;
import com.example.demo.shared.dto.TerrainDTO;

@Service
public class ProprietaireServiceImpl implements ProprietaireService {
	
	@Autowired
	ProprietaireRepository proprietaireRepository;
	@Autowired
	Utils utils;
	@Override
	public ProprietaireDto createProprietaire(ProprietaireDto proprietaireDto) {
		// TODO Auto-generated method stub
		Proprietaire proprietaireCheck=proprietaireRepository.findByemail(proprietaireDto.getEmail());
		if(proprietaireCheck!=null) throw new RuntimeException("Proprietaire Already Exists");
		
		for(int i=0;i<proprietaireDto.getTerrains().size();i++) {
			TerrainDTO terrain=proprietaireDto.getTerrains().get(i);
			terrain.setProprietaire(proprietaireDto);
			terrain.setTerraiid(utils.generateStringId(30));
			proprietaireDto.getTerrains().set(i, terrain);
		}
		
		ModelMapper modelMapper=new ModelMapper();
		Proprietaire proprietaire=modelMapper.map(proprietaireDto, Proprietaire.class);
		
		proprietaire.setProprietaireid(utils.generateStringId(30));
		proprietaire.setEncryptedPassword("ABCDEF");
		
		Proprietaire newProprietaire = proprietaireRepository.save(proprietaire);
		
		ProprietaireDto dto=modelMapper.map(newProprietaire, ProprietaireDto.class);
		
		return dto;
	}

	@Override
	public ProprietaireDto GetProprietaireById(String id) {
		// TODO Auto-generated method stub
		Proprietaire proprietaire=proprietaireRepository.findByproprietaireid(id);
	
		if(proprietaire==null) throw new RuntimeException("Proprietaire Not Exists");
	
		ModelMapper modelMapper=new ModelMapper();
		ProprietaireDto dto=modelMapper.map(proprietaire, ProprietaireDto.class);
		
		return dto;
	}

	@Override
	public ProprietaireDto Update(String id, ProprietaireDto proprietaireDto) {
		// TODO Auto-generated method stub
		Proprietaire proprietaire=proprietaireRepository.findByproprietaireid(id);
		if(proprietaire==null) throw new RuntimeException("Proprietaire Not Exists");
		
		proprietaire.setFirstName(proprietaireDto.getFirstName());
		proprietaire.setLastName(proprietaireDto.getLastName());
		
		Proprietaire proprietaireUpdate=proprietaireRepository.save(proprietaire);
		ModelMapper modelMapper=new ModelMapper();
		
		ProprietaireDto proprietaireDto2=modelMapper.map(proprietaireUpdate, ProprietaireDto.class);
		
		return proprietaireDto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Proprietaire proprietaire=proprietaireRepository.findByproprietaireid(id);
		
		if(proprietaire==null) throw new RuntimeException("Proprietaire Not Exists");
		proprietaireRepository.delete(proprietaire);
	}

	@Override
	public List<ProprietaireDto> getAllProprietaire() {
		// TODO Auto-generated method stub
		List<Proprietaire> proprietaires=proprietaireRepository.findAll();
		
		List<ProprietaireDto> proprietaireDtos=new ArrayList<>();
		for (Proprietaire proprietaire : proprietaires) {
			ModelMapper modelMapper=new ModelMapper();

			ProprietaireDto proprietaireDto=modelMapper.map(proprietaire, ProprietaireDto.class);
			
			proprietaireDtos.add(proprietaireDto);
		}
		return proprietaireDtos;
	}

	@Override
	public ProprietaireDto getUser(String email) {
		// TODO Auto-generated method stub
		Proprietaire proprietaire=proprietaireRepository.findByemail(email);
		if(proprietaire==null) throw new RuntimeException("Proprietaire Not Exists");
		
		ModelMapper modelMapper=new ModelMapper();
		ProprietaireDto proprietaireDto=modelMapper.map(proprietaire, ProprietaireDto.class);
		
		return proprietaireDto;
	}

}
