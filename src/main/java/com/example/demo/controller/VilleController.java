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

import com.example.demo.reponse.VilleResponse;
import com.example.demo.request.VilleRequest;
import com.example.demo.services.VilleService;
import com.example.demo.shared.dto.VilleDto;

@RestController
@RequestMapping("/ville")
@CrossOrigin("http://localhost:4200")
public class VilleController  {
		
		@Autowired
		VilleService villeService;
		@PostMapping
		public VilleResponse save(@RequestBody VilleRequest villeRequest) {
			VilleDto dto=new VilleDto();
			BeanUtils.copyProperties(villeRequest, dto);
			
			VilleDto createville=villeService.CreateVille(dto);
			VilleResponse response=new VilleResponse();
			BeanUtils.copyProperties(createville, response);
			return response;
		}
		
		@GetMapping(path = "/{nom}")
		public VilleResponse GetByName(@PathVariable String nom){
			
			VilleDto dto=villeService.GetByNom(nom);
			VilleResponse villeResponse=new VilleResponse();
			BeanUtils.copyProperties(dto, villeResponse);
			
			return villeResponse;
		}
		
		@GetMapping
		public List<VilleResponse> GetAll(){
			List<VilleResponse> villelist=new ArrayList<>();
			List<VilleDto> ville=villeService.GetAllVille();
			for (VilleDto villeDto : ville) {
				VilleResponse response=new VilleResponse();
				BeanUtils.copyProperties(villeDto, response);
				
				villelist.add(response);
			}
			return villelist;
		}
		
		@PutMapping(path = "/{id}")
		public ResponseEntity<VilleResponse> Update(@PathVariable String id,@RequestBody VilleRequest request){
			
			VilleDto dto=new VilleDto();
			
			BeanUtils.copyProperties(request, dto);
			
			VilleDto dto2=villeService.Update(id, dto);
			VilleResponse response=new VilleResponse();
			
			BeanUtils.copyProperties(dto2, response);
			
			
			return new ResponseEntity<VilleResponse>(response,HttpStatus.CREATED);
		}
		
		@DeleteMapping(path = "/{id}")
		public ResponseEntity<Object> Delete(@PathVariable String id) {
			villeService.Delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		@GetMapping(path = "get/{id}")
		public VilleResponse GetById(String id) {
			VilleDto dto=villeService.GetVilleById(id);
			VilleResponse response=new VilleResponse();
			BeanUtils.copyProperties(dto, response);
			return response;
		}

}
