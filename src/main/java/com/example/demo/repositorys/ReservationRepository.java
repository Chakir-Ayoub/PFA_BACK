package com.example.demo.repositorys;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	Reservation findByidreservation(String id);
	Reservation findBydate(Date date);
}
