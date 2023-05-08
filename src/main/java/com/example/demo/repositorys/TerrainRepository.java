package com.example.demo.repositorys;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Proprietaire;
import com.example.demo.entity.Terrain;
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
	Terrain findByterraiid(String id);
	Terrain findBynom(String nom);
	List<Terrain> findByproprietaire(Proprietaire currentProprietaire);
}
