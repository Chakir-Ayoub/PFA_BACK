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

import com.example.demo.entity.Club;
import com.example.demo.reponse.ClubResponse;
import com.example.demo.request.ClubRequest;
import com.example.demo.services.ClubService;
import com.example.demo.shared.dto.ClubDTO;

@RestController
@RequestMapping("/club")
@CrossOrigin("http://localhost:4200")
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@GetMapping
	public ResponseEntity<List<ClubResponse>> GetAll(){
		List<ClubResponse> clubResponses=new ArrayList<>();
		List<ClubDTO> clubDTOs= clubService.GetAll();
		
		for (ClubDTO clubDTO : clubDTOs) {
			ClubResponse clubResponse=new ClubResponse();
			BeanUtils.copyProperties(clubDTO, clubResponse);
			
			clubResponses.add(clubResponse);
		}
		return new ResponseEntity<List<ClubResponse>>(clubResponses,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<ClubResponse> Save(@RequestBody ClubRequest clubRequest) throws Exception{
		ClubDTO clubDTO=new ClubDTO();
		BeanUtils.copyProperties(clubRequest, clubDTO);
		
		
		ClubDTO createclub=clubService.CreateClub(clubDTO);
		ClubResponse clubResponse=new ClubResponse();
		BeanUtils.copyProperties(createclub, clubResponse);
		
		
		return new ResponseEntity<ClubResponse>(clubResponse,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ClubResponse> Update(@PathVariable String id,@RequestBody ClubRequest clubRequest){
		
		ClubDTO clubDTO=new ClubDTO();
		
		BeanUtils.copyProperties(clubRequest, clubDTO);
		
		ClubDTO clubDTO2=clubService.Update(id, clubDTO);
		ClubResponse clubResponse=new ClubResponse();
		
		BeanUtils.copyProperties(clubDTO2, clubResponse);
		
		return new ResponseEntity<ClubResponse>(clubResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		clubService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path =  "/GetByname/{name}")
	public ResponseEntity<ClubResponse> GetByName(@PathVariable String name){
		
		ClubDTO clubDTO= clubService.GetClubBynom(name);
		ClubResponse club=new ClubResponse();
		
		BeanUtils.copyProperties(clubDTO, club);
		return new ResponseEntity<ClubResponse>(club,HttpStatus.ACCEPTED);
	}
	
}
