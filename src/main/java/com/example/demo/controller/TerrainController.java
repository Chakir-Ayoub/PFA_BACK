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

import com.example.demo.reponse.TerrainResponse;
import com.example.demo.request.TerrainRequest;
import com.example.demo.services.TerrainService;
import com.example.demo.shared.dto.TerrainDTO;

@RestController
@RequestMapping("/terrain")
@CrossOrigin("http://localhost:4200/")
public class TerrainController {
	@Autowired
	TerrainService terrainService;
	
	@GetMapping
	public ResponseEntity<List<TerrainResponse>> GetAll()
	{
		List<TerrainResponse> list=new ArrayList<>();
		List<TerrainDTO> list2=terrainService.GetAll();
		
		for (TerrainDTO terrainDTO : list2) {
			TerrainResponse response=new TerrainResponse();
			BeanUtils.copyProperties(terrainDTO, response);
			
			list.add(response);
		}
		return new ResponseEntity<List<TerrainResponse>>(list,HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<TerrainResponse> Save(@RequestBody TerrainRequest request) throws Exception
	{
		TerrainDTO dto=new TerrainDTO();
		BeanUtils.copyProperties(request, dto);
		
		TerrainDTO dto2=terrainService.CreateTerrain(dto);
		TerrainResponse response=new TerrainResponse();
		BeanUtils.copyProperties(dto2, response);
		
		return new ResponseEntity<TerrainResponse>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<TerrainResponse> Update(@PathVariable String id,@RequestBody TerrainRequest request)
	{
		TerrainDTO dto=new TerrainDTO();
		
		BeanUtils.copyProperties(request, dto);
		
		TerrainDTO dto2=terrainService.Update(id, dto);
		TerrainResponse response=new TerrainResponse();
		
		BeanUtils.copyProperties(dto2, response);
		
		return new ResponseEntity<TerrainResponse>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id) 
	{
		terrainService.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
