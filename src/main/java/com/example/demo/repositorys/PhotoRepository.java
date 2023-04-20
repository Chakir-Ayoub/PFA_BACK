package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	Photo findByurl(String url);
	Photo findByphotoid(String photoid);
}
