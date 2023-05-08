package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proprietaire;
import com.example.demo.entity.Terrain;
import com.example.demo.repositorys.ProprietaireRepository;
import com.example.demo.repositorys.TerrainRepository;
import com.example.demo.services.TerrainService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.TerrainDTO;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;


@Service
public class TerrainServiceIMPL implements TerrainService {
	@Autowired
	TerrainRepository repository;
	@Autowired
	ProprietaireRepository proprietaireRepository;
	@Autowired
	Utils utils;
	@Override
	public TerrainDTO CreateTerrain(TerrainDTO dto) {
		// TODO Auto-generated method stub
		Terrain check=repository.findBynom(dto.getNom());
		if(check!=null) throw new RuntimeException("Already Exists");
		
		Terrain terrain=new Terrain();
		BeanUtils.copyProperties(dto, terrain);
		
		terrain.setTerraiid(utils.generateStringId(32));
		
		Terrain CreateTerrain=repository.save(terrain);
		TerrainDTO dto2=new TerrainDTO();
		
		BeanUtils.copyProperties(CreateTerrain, dto2);
		
		return dto2;
	}

	@Override
	public List<TerrainDTO> GetAll(String email) {
		// TODO Auto-generated method stub
		Proprietaire currentProprietaire=proprietaireRepository.findByemail(email);

	
		List<Terrain> terrains=currentProprietaire.getAdmin()==true? (List<Terrain>) repository.findAll() : (List<Terrain>) repository.findByproprietaire(currentProprietaire);
		
		Type listeType=new TypeToken<List<TerrainDTO>>() {}.getType();
		
		List<TerrainDTO> terrainDTOs=new ModelMapper().map(terrains, listeType);
		/*List<TerrainDTO> dtos=new ArrayList<>();
		for (Terrain terrain : terrains) {
			TerrainDTO dto=new TerrainDTO();
			BeanUtils.copyProperties(terrain, dto);
			
			dtos.add(dto);
		}*/
		return terrainDTOs;
	}

	@Override
	public TerrainDTO Update(String id, TerrainDTO dto) {
		// TODO Auto-generated method stub
		Terrain terrain=repository.findByterraiid(id);
		if(terrain==null) throw new RuntimeException("Not Exists");
		
		
		terrain.setAdresse(dto.getAdresse());
		terrain.setAttitude(dto.getAttitude());
		terrain.setClub(dto.getClub());
		terrain.setDescriptuon(dto.getDescriptuon());
		terrain.setEtat(dto.getEtat());
		terrain.setLongitude(dto.getLongitude());
		terrain.setNom(dto.getNom());
		terrain.setType(dto.getType());
		terrain.setTarif(dto.getTarif());
		terrain.setZone(dto.getZone());
		
		Terrain updateterrain = repository.save(terrain);
		TerrainDTO dto2=new TerrainDTO();
		
		BeanUtils.copyProperties(updateterrain, dto2);
		
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Terrain terrain=repository.findByterraiid(id);
		if(terrain==null) throw new RuntimeException("Not Exists");
		
		repository.delete(terrain);
	}

}
