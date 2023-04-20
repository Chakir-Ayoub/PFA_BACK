package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Abonnement;
import com.example.demo.reponse.AbonnementResponse;
import com.example.demo.request.AbonnementRequest;
import com.example.demo.services.AbonnementService;
import com.example.demo.shared.dto.AbonnementDTO;

import jakarta.validation.constraints.DecimalMax;

@RestController
@RequestMapping("abonnement")
@CrossOrigin("http://localhost:4200")
public class AbonnementController {
	@Autowired
	AbonnementService abonnementService;
	
	@GetMapping
	public ResponseEntity<List<AbonnementResponse>> GetAll(){
		List<AbonnementResponse> abonnementResponse=new ArrayList<>();
		List<AbonnementDTO> abonnementDTOs=abonnementService.GetAll();

		for (AbonnementDTO abonnementDTO : abonnementDTOs) {
			AbonnementResponse abonnement=new AbonnementResponse();
			BeanUtils.copyProperties(abonnementDTO, abonnement);
			
			abonnementResponse.add(abonnement);
		}
		
		return new ResponseEntity<List<AbonnementResponse>>( abonnementResponse,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<AbonnementResponse> Save(@RequestBody AbonnementRequest abonnementRequest) throws Exception{
		AbonnementDTO abonnementDTO=new AbonnementDTO();
		BeanUtils.copyProperties(abonnementRequest, abonnementDTO);
		
		AbonnementDTO createabonnement=abonnementService.CreateAonnement(abonnementDTO);
		AbonnementResponse abonnementResponse=new AbonnementResponse();
		BeanUtils.copyProperties(createabonnement, abonnementResponse);
		
		return new ResponseEntity<AbonnementResponse>(abonnementResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<AbonnementResponse> Update(@PathVariable String id,@RequestBody AbonnementRequest abonnementRequest){
		AbonnementDTO abonnementDTO=new AbonnementDTO();
		
		BeanUtils.copyProperties(abonnementRequest, abonnementDTO);
		
		AbonnementDTO DTO2=abonnementService.UpdateAonnement(id, abonnementDTO);
		AbonnementResponse response=new AbonnementResponse();
		
		BeanUtils.copyProperties(DTO2, response);
		
		return new ResponseEntity<AbonnementResponse>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		abonnementService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
