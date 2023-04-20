package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {
Club findBynom(String nom);
Club findByidclub(String id);
}
