package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reponse.AbonnementResponse;
import com.example.demo.reponse.PackeResponse;
import com.example.demo.request.AbonnementRequest;
import com.example.demo.request.PackeRequest;
import com.example.demo.services.PackeService;
import com.example.demo.shared.dto.AbonnementDTO;
import com.example.demo.shared.dto.PackeDTO;

@RestController
@RequestMapping("/packe")
@CrossOrigin("http://localhost:4200/")
public class PackeController {
	@Autowired
	PackeService packeService;
	
	@GetMapping
	public ResponseEntity<List<PackeResponse>> GetAll(){
		List<PackeResponse> packeResponsess=new ArrayList<>();
		List<PackeDTO> dtos=packeService.getAll();
		
		for (PackeDTO packeDTO : dtos) {
			PackeResponse packeResponse=new PackeResponse();
			BeanUtils.copyProperties(packeDTO, packeResponse);
			
			packeResponsess.add(packeResponse);
		}
		return new ResponseEntity<List<PackeResponse>>(packeResponsess,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<PackeResponse> Save(@RequestBody PackeResponse packeResponse) throws Exception{
		PackeDTO packeDTO =new PackeDTO();
		
		BeanUtils.copyProperties(packeResponse, packeDTO);
		
		PackeDTO createpack=packeService.createPacke(packeDTO);
		PackeResponse packeResponse2=new PackeResponse();
		BeanUtils.copyProperties(createpack, packeResponse2);
		
		return new ResponseEntity<PackeResponse>(packeResponse2,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<PackeResponse> Update(@PathVariable String id,@RequestBody PackeRequest packeRequest)
	{
		PackeDTO dto=new PackeDTO();
		
		BeanUtils.copyProperties(packeRequest, dto);
		
		PackeDTO dto2=packeService.Update(id, dto);
		PackeResponse packeResponse=new PackeResponse();
		
		BeanUtils.copyProperties(dto2, packeResponse);
		
		return new ResponseEntity<PackeResponse>(packeResponse,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id)
	{
		packeService.Delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
