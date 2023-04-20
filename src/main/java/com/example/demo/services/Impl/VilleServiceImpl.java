package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ville;
import com.example.demo.repositorys.VilleRepository;
import com.example.demo.services.VilleService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.VilleDto;

@Service
public class VilleServiceImpl implements VilleService {
	@Autowired
	VilleRepository repository;
	@Autowired
	Utils utils;
	@Override
	public VilleDto CreateVille(VilleDto dto) {
		// TODO Auto-generated method stub
		Ville ville =new Ville();
		BeanUtils.copyProperties(dto, ville);
		
		ville.setVilleid(utils.generateStringId(32));

		Ville villle=repository.save(ville);
		VilleDto villeDto =new VilleDto();
		
		BeanUtils.copyProperties(villle, villeDto);
		return villeDto;
	}

	@Override
	public VilleDto GetByNom(String nom) {
		// TODO Auto-generated method stub
		Ville ville=repository.findBynom(nom);
		VilleDto dto=new VilleDto();
		BeanUtils.copyProperties(ville, dto);
		return dto;
	}

	@Override
	public VilleDto Update(String id, VilleDto villeDto) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		if(ville==null) throw new RuntimeException();
		ville.setNom(villeDto.getNom());
		
		Ville villeupdate=repository.save(ville);
		VilleDto dto=new VilleDto();
		BeanUtils.copyProperties(villeupdate, dto);
		return dto;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		if(ville==null) throw new RuntimeException("Ville Not exist");
		repository.delete(ville);
	}

	@Override
	public List<VilleDto> GetAllVille() {
		// TODO Auto-generated method stub
		List<VilleDto> villeDtos=new ArrayList<>();
		List<Ville> villes=repository.findAll();
		
		for (Ville ville : villes) {
			VilleDto dto=new VilleDto();
			BeanUtils.copyProperties(ville, dto);
			
			villeDtos.add(dto);
		}
		return villeDtos;
	}

	@Override
	public VilleDto GetVilleById(String id) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		VilleDto dto=new VilleDto();
		if(ville==null) throw new RuntimeException("Ville Not Found");
		
		BeanUtils.copyProperties(ville, dto);
		return dto;
	}

}
