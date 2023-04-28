package com.example.demo.services;

import com.example.demo.shared.dto.OccupationDTO;
import java.util.*;
public interface OccupationService {
	OccupationDTO CreateOccupation(OccupationDTO dto);
	List<OccupationDTO> GetAll();
	OccupationDTO UpdateOccupation(String id,OccupationDTO occupationDTO);
	void Delete(String id);
}
