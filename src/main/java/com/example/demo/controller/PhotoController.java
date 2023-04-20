package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Photo;
import com.example.demo.reponse.PhotoResponse;
import com.example.demo.repositorys.PhotoRepository;
import com.example.demo.request.PhotoRequest;
import com.example.demo.services.PhotoService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.PhotoDto;

@RestController
@RequestMapping("/photo")
@CrossOrigin("http://localhost:4200")

public class PhotoController {
	@Autowired
	PhotoService photoService;
	@Autowired 
	PhotoRepository photoRepository;
	@Autowired
	Utils utils;
	
	@PostMapping
	public PhotoResponse CreatePhoto(@RequestBody PhotoRequest photoRequest) {
		PhotoDto dto=new PhotoDto();
		BeanUtils.copyProperties(photoRequest, dto);
		
		PhotoDto createphoto=photoService.CreatePhoto(dto);
		PhotoResponse photoResponse=new PhotoResponse();
		BeanUtils.copyProperties(createphoto, photoResponse);
		return photoResponse;		
	}
	
	@GetMapping(path = "/{url}")
	public PhotoResponse GetByUrl(String url) {
		PhotoDto dto=photoService.GetAllbyUrl(url);
		PhotoResponse photoResponse=new PhotoResponse();
		BeanUtils.copyProperties(dto, photoResponse);
		return photoResponse;
	}
	
	@GetMapping
	public List<PhotoResponse> GetAll(){
		List<PhotoResponse> photoResponses=new ArrayList<>();
		List<PhotoDto> dtos=photoService.GetAllPhoto();
		for (PhotoDto photoDto : dtos) {
			PhotoResponse photoResponse=new  PhotoResponse();
			BeanUtils.copyProperties(photoDto, photoResponse);
			
			photoResponses.add(photoResponse);
		}
		return photoResponses;
	}
	
	@PutMapping(path = "/{id}")
	public PhotoResponse Update(@PathVariable String id,@RequestBody PhotoRequest photoRequest) {
		PhotoDto dto=new PhotoDto();
		BeanUtils.copyProperties(photoRequest, dto);
		
		PhotoDto dto2=photoService.Update(id, dto);
		PhotoResponse photoResponse=new PhotoResponse();
		
		BeanUtils.copyProperties(dto2, photoResponse);
		
		return photoResponse;
	}
	
	@DeleteMapping(path = "/{id}") 
	public void Delete(@PathVariable String id) {
		photoService.Delete(id);
	}
}
