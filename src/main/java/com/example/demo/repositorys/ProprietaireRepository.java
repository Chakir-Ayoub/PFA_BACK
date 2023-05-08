package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Proprietaire;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
	Proprietaire findByproprietaireid(String id);
	Proprietaire findByemail(String email);
}
