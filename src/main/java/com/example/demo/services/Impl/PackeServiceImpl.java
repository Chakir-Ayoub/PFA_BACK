package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Packe;
import com.example.demo.repositorys.PackeRepository;
import com.example.demo.services.PackeService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.PackeDTO;

@Service
public class PackeServiceImpl implements PackeService {
	
	@Autowired
	PackeRepository packeRepository;
	@Autowired
	Utils utils;
	@Override
	public PackeDTO createPacke(PackeDTO dto) {
		// TODO Auto-generated method stub
		Packe packe=new Packe();
		BeanUtils.copyProperties(dto, packe);
		
		packe.setIdpacke(utils.generateStringId(32));
		
		Packe newpacke=packeRepository.save(packe);
		PackeDTO dto2=new PackeDTO();
		
		BeanUtils.copyProperties(newpacke, dto2);
		return dto2;
	}

	@Override
	public PackeDTO Update(String id, PackeDTO dto) {
		// TODO Auto-generated method stub
		Packe packe=packeRepository.findByidpacke(id);
		if(packe==null) throw new RuntimeException("Already Exists");
		
		packe.setClub(dto.getClub());
		packe.setNbr_match(dto.getNbr_match());
		packe.setNom(dto.getNom());
		packe.setTarif(dto.getTarif());
		
		Packe packeupdate=packeRepository.save(packe);
		PackeDTO dto2=new PackeDTO();
		
		BeanUtils.copyProperties(packeupdate, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Packe packe=packeRepository.findByidpacke(id);
		if(packe==null) throw new RuntimeException("Already Exists");
		
		packeRepository.delete(packe);
	}

	@Override
	public List<PackeDTO> getAll() {
		// TODO Auto-generated method stub
		List<PackeDTO> dtos=new ArrayList<>();
		List<Packe> packe=packeRepository.findAll();
		
		for (Packe packe2 : packe) {
			PackeDTO dto=new PackeDTO();
			BeanUtils.copyProperties(packe2, dto);
			
			dtos.add(dto);
		}
		return dtos;
	}

}
