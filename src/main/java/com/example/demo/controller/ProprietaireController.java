package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.example.demo.reponse.ProprietaireResponse;
import com.example.demo.request.ProprietaireRequest;
import com.example.demo.services.ProprietaireService;
import com.example.demo.shared.dto.ProprietaireDto;

@RestController
@RequestMapping("/proprietaire")
@CrossOrigin("http://localhost:4200")
public class ProprietaireController {
	@Autowired
	ProprietaireService proprietaireService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProprietaireResponse> Get(@PathVariable String id){
		ProprietaireDto dto=proprietaireService.GetProprietaireById(id);
		
		ModelMapper modelMapper=new ModelMapper();
		ProprietaireResponse proprietaireResponse=modelMapper.map(dto, ProprietaireResponse.class);
		
		return new ResponseEntity<ProprietaireResponse>(proprietaireResponse,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping
	public List<ProprietaireResponse> GetAll(){
		List<ProprietaireResponse> proprietaireResponses=new ArrayList<>();
		
		List<ProprietaireDto> proprietaireDtos=proprietaireService.getAllProprietaire();
		
		for (ProprietaireDto proprietaireDto : proprietaireDtos) {
			ModelMapper modelMapper=new ModelMapper();
			ProprietaireResponse proprietaireResponse=modelMapper.map(proprietaireDto, ProprietaireResponse.class);
			
			proprietaireResponses.add(proprietaireResponse);
		}
		return proprietaireResponses;
	}
	
	@PostMapping
	public ResponseEntity<ProprietaireResponse> Save(@RequestBody ProprietaireRequest  proprietaireRequest) throws Exception{
         
		ModelMapper modelMapper=new ModelMapper();
		ProprietaireDto proprietaireDto=modelMapper.map(proprietaireRequest, ProprietaireDto.class);
		
		ProprietaireDto createProp=proprietaireService.createProprietaire(proprietaireDto);
		ProprietaireResponse proprietaireResponse=modelMapper.map(createProp, ProprietaireResponse.class);
		
		return new ResponseEntity<ProprietaireResponse>(proprietaireResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ProprietaireResponse> Update(@PathVariable String id,@RequestBody ProprietaireRequest proprietaireRequest) throws Exception{
		ModelMapper modelMapper=new ModelMapper();
		
		ProprietaireDto proprietaireDto=modelMapper.map(proprietaireRequest, ProprietaireDto.class);
		
		ProprietaireDto proprietaireDto2=proprietaireService.Update(id, proprietaireDto);
		
		ProprietaireResponse proprietaireResponse=modelMapper.map(proprietaireDto2, ProprietaireResponse.class);
		
		return new ResponseEntity<ProprietaireResponse>(proprietaireResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		proprietaireService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
