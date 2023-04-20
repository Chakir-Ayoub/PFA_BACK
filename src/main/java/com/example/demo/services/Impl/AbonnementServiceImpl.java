package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Abonnement;
import com.example.demo.repositorys.AbonnementRepository;
import com.example.demo.services.AbonnementService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.AbonnementDTO;

@Service
public class AbonnementServiceImpl implements AbonnementService {
	
	@Autowired
	AbonnementRepository abonnementRepository;
	@Autowired
	Utils utils;
	@Override
	public AbonnementDTO CreateAonnement(AbonnementDTO abonnementDTO) {
		// TODO Auto-generated method stub
		Abonnement abonnement=new Abonnement();
		BeanUtils.copyProperties(abonnementDTO, abonnement);
		
		abonnement.setIdabonnement(utils.generateStringId(32));
		
		Abonnement newAbonnement=abonnementRepository.save(abonnement);
		AbonnementDTO abonnementDTO2=new AbonnementDTO();
		
		BeanUtils.copyProperties(newAbonnement, abonnementDTO2);
		return abonnementDTO2;
	}

	@Override
	public List<AbonnementDTO> GetAll() {
		// TODO Auto-generated method stub
		List<AbonnementDTO> abonnementDTOs=new ArrayList<>();
		List<Abonnement> abonnements=abonnementRepository.findAll();
		
		for (Abonnement abonnement : abonnements) {
			AbonnementDTO DTO =new AbonnementDTO();
			BeanUtils.copyProperties(abonnement, DTO);
			
			abonnementDTOs.add(DTO);
		}
		return abonnementDTOs;
	}

	@Override
	public AbonnementDTO UpdateAonnement(String id,AbonnementDTO abonnementDTO) {
		// TODO Auto-generated method stub
		Abonnement abonnement=abonnementRepository.findByidabonnement(id);
		if(abonnement==null) throw new RuntimeException("Abonnement Not Exist");
		
		abonnement.setClient(abonnementDTO.getClient());
		abonnement.setDate(abonnementDTO.getDate());
		abonnement.setPacke(abonnementDTO.getPacke());
		
		Abonnement abonnementUpdate=abonnementRepository.save(abonnement);
		AbonnementDTO abonnementDTO2=new AbonnementDTO();
		
		BeanUtils.copyProperties(abonnementUpdate, abonnementDTO2);
		
		return abonnementDTO2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Abonnement abonnement=abonnementRepository.findByidabonnement(id);
		if(abonnement==null) throw new RuntimeException("Abonnement Not Exist");
		
		abonnementRepository.delete(abonnement);
	}

}
