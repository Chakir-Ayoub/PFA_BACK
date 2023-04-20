package com.example.demo.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.repositorys.ReservationRepository;
import com.example.demo.services.ReservationService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.ReservationDTO;

@Service
public class ReservationServiceIMPL implements ReservationService {
	@Autowired
	ReservationRepository repository;
	@Autowired
	Utils utils;
	
	
	@Override
	public ReservationDTO CreateReservation(ReservationDTO dto) {
		// TODO Auto-generated method stub
		Reservation check=repository.findBydate(dto.getDate());
		if(check!=null) throw new RuntimeException("Already Reserved");
		
		Reservation reservation=new Reservation();
		BeanUtils.copyProperties(check, reservation);
		
		reservation.setIdreservation(utils.generateStringId(32));
		
		Reservation createreservation=repository.save(reservation);
		ReservationDTO dto2=new ReservationDTO();
		
		BeanUtils.copyProperties(createreservation, dto2);
		return dto2;
	}

	@Override
	public ReservationDTO GetReservationById(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDTO Update(String id, ReservationDTO dto) {
		// TODO Auto-generated method stub
		Reservation reservation=repository.findByidreservation(id);
		if(reservation==null) throw new RuntimeException("Not Exists");
		
		reservation.setClientid(dto.getClientid());
		reservation.setDate(dto.getDate());
		reservation.setEtat(dto.getEtat());
		
		Reservation updateReservation=repository.save(reservation);
		ReservationDTO dto2=new ReservationDTO();
		
		BeanUtils.copyProperties(updateReservation, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Reservation reservation=repository.findByidreservation(id);
		if(reservation==null) throw new RuntimeException("Not Exists");
		
		repository.delete(reservation);
	}

	@Override
	public List<ReservationDTO> getAllResrvation() {
		// TODO Auto-generated method stub
		List<ReservationDTO> dtos=new ArrayList<>();
		List<Reservation> list=repository.findAll();
		
		for (Reservation reservation : list) {
			ReservationDTO dto=new ReservationDTO();
			BeanUtils.copyProperties(reservation, dto);
			
			dtos.add(dto);
		}
		return dtos;
	}

}
