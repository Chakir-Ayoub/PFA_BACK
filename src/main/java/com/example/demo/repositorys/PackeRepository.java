package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Packe;

@Repository
public interface PackeRepository extends JpaRepository<Packe, Integer> {
	Packe findByidpacke(String id);
}
