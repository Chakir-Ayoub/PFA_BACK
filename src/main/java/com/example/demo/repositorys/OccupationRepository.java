package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Integer> {
	Occupation findByidoccupation(String id);
}
