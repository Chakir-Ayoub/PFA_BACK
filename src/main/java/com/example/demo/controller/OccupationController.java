package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.demo.reponse.OccupationResponse;
import com.example.demo.request.OccupationRequest;
import com.example.demo.services.OccupationService;
import com.example.demo.shared.dto.OccupationDTO;
import com.example.demo.shared.dto.VilleDto;

@RestController
@RequestMapping("/occupation")
@CrossOrigin("http://localhost:4200")
public class OccupationController {
	
	@Autowired
	OccupationService occupationService;
	
	@PostMapping
	public OccupationResponse Save(@RequestBody OccupationRequest occupationRequest) {
		
		OccupationDTO occupationDTO =new OccupationDTO();
		BeanUtils.copyProperties(occupationRequest, occupationDTO);
		
		OccupationDTO createOccupation=occupationService.CreateOccupation(occupationDTO);
		OccupationResponse response=new OccupationResponse();
		BeanUtils.copyProperties(createOccupation, response);
		return response;
	}
	
	@GetMapping
	public List<OccupationResponse> GetAll(){
		List<OccupationResponse> occupationList=new ArrayList<>();
		List<OccupationDTO> occupationDTOs =occupationService.GetAll();
		for (OccupationDTO occupationDTO : occupationDTOs) {
			OccupationResponse response=new OccupationResponse();
			BeanUtils.copyProperties(occupationDTO, response);
			
			occupationList.add(response);
		}
		return occupationList;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<OccupationResponse> Update(@PathVariable String id,@RequestBody OccupationRequest occupationRequest) {
		OccupationDTO occupationDTO=new OccupationDTO();
		
		BeanUtils.copyProperties(occupationRequest, occupationDTO);
		
		OccupationDTO occupationDTO2=occupationService.UpdateOccupation(id, occupationDTO);
		OccupationResponse response=new OccupationResponse();
		
		BeanUtils.copyProperties(occupationDTO2, response);
		
		
		return new ResponseEntity<OccupationResponse>(response,HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		occupationService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
