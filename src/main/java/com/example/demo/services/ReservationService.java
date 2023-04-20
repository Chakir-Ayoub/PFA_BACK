package com.example.demo.services;

import java.util.List;

import com.example.demo.shared.dto.ReservationDTO;


public interface ReservationService {
	ReservationDTO CreateReservation(ReservationDTO dto);
	ReservationDTO GetReservationById(String reservationId);
	ReservationDTO Update(String id,ReservationDTO dto);
	void Delete(String id);
	List<ReservationDTO> getAllResrvation();
}
