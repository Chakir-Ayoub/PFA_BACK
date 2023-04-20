package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Abonnement;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {
 Abonnement findByidabonnement(String id);
}
