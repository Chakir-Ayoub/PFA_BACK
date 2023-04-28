package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Occupation;
import com.example.demo.repositorys.OccupationRepository;
import com.example.demo.services.OccupationService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.OccupationDTO;

@Service
public class OcuppationImpl implements OccupationService {
	@Autowired
	OccupationRepository occupationRepository;
	@Autowired
	Utils utils;
	
	@Override
	public OccupationDTO CreateOccupation(OccupationDTO dto) {
		// TODO Auto-generated method stub
		Occupation occupation=new Occupation();
		BeanUtils.copyProperties(dto, occupation);
		
		occupation.setIdoccupation(utils.generateStringId(32));
		
		Occupation occupation2=occupationRepository.save(occupation);
		OccupationDTO occupationDTO=new OccupationDTO();
		
		BeanUtils.copyProperties(occupation2, occupationDTO);
		return occupationDTO;
	}

	@Override
	public List<OccupationDTO> GetAll() {
		// TODO Auto-generated method stub
		List<OccupationDTO> occupationDTOs=new ArrayList<>();
		List<Occupation> occupations=occupationRepository.findAll();
		
		for (Occupation occupation : occupations) {
			OccupationDTO dto=new OccupationDTO();
			BeanUtils.copyProperties(occupation, dto);
			
			occupationDTOs.add(dto);
		}
		return occupationDTOs;
	}

	@Override
	public OccupationDTO UpdateOccupation(String id, OccupationDTO occupationDTO) {
		// TODO Auto-generated method stub
		Occupation occupation=occupationRepository.findByidoccupation(id);
		if(occupation==null) throw new RuntimeException();
		occupation.setDate(occupationDTO.getDate());
		occupation.setHeure(occupationDTO.getHeure());
		occupation.setReservation(occupationDTO.getReservation());
		occupation.setTerrain(occupation.getTerrain());
		
		Occupation occupationUpdate=occupationRepository.save(occupation);
		OccupationDTO occupationDTO2=new OccupationDTO();
		BeanUtils.copyProperties(occupationUpdate, occupationDTO2);
		return occupationDTO2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Occupation occupation=occupationRepository.findByidoccupation(id);
		if(occupation==null) throw new RuntimeException("occupation Not exists");
		occupationRepository.delete(occupation);

	}

}
