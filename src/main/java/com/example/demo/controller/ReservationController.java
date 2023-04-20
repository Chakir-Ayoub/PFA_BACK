package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reponse.ReservationRequest;
import com.example.demo.services.ReservationService;
import com.example.demo.shared.dto.ReservationDTO;

@RestController
@RequestMapping("reservtion")
@CrossOrigin("http://localhost:4200/")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping
	public ResponseEntity<List<ReservationResponse>> GetAll()
	{
		List<ReservationResponse> reservationResponses=new ArrayList<>();
		List<ReservationDTO> reservationDTOs=reservationService.getAllResrvation();
		
		for (ReservationDTO reservationDTO : reservationDTOs) {
			ReservationResponse reservationResponse=new ReservationResponse();
			BeanUtils.copyProperties(reservationDTO, reservationResponse);
			
			reservationResponses.add(reservationResponse);
			
		}
		return new ResponseEntity<List<ReservationResponse>>(reservationResponses,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<ReservationResponse> Save(@RequestBody ReservationRequest request) throws Exception{
		ReservationDTO dto=new ReservationDTO();
		BeanUtils.copyProperties(request, dto);
		
		ReservationDTO createreservation=reservationService.CreateReservation(dto);
		ReservationResponse reservationResponse=new ReservationResponse();
		BeanUtils.copyProperties(createreservation, reservationResponse);
		
		return new ResponseEntity<ReservationResponse>(reservationResponse,HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ReservationResponse> Update(@PathVariable String id,@RequestBody ReservationRequest request)
	{
		ReservationDTO dto=new ReservationDTO();
		
		BeanUtils.copyProperties(request, dto);
		
		ReservationDTO dto2=reservationService.Update(id, dto);
		ReservationResponse reservationResponse=new ReservationResponse();
		
		BeanUtils.copyProperties(dto2, reservationResponse);
		
		return new ResponseEntity<ReservationResponse>(reservationResponse,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Object> Delete(@PathVariable String id)
	{
		reservationService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
