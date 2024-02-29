package com.example.SpringEsercizio15.repositories;

import com.example.SpringEsercizio15.Entities.Flight;
import com.example.SpringEsercizio15.Entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT * FROM Flight WHERE flight_status LIKE 'ONTIME'",nativeQuery = true)
    List<Flight> flightStatus(FlightStatus ONTIME);
}