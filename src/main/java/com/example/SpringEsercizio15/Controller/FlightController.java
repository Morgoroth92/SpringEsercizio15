package com.example.SpringEsercizio15.Controller;

import com.example.SpringEsercizio15.Entities.Flight;
import com.example.SpringEsercizio15.Entities.FlighStatus;
import com.example.SpringEsercizio15.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/provisioning")
    public List<Flight> fillListOfFlight() {
        for (int i = 0; i <= 50; i++) {
            Random randomNumbers = new Random();
            Integer int_description = randomNumbers.nextInt(999999);
            Integer int_fromAirport = randomNumbers.nextInt(999999);
            Integer int_toAirport = randomNumbers.nextInt(999999);
            String descriptionString = int_description.toString();
            String fromAirportString = int_fromAirport.toString();
            String toAirportString = int_toAirport.toString();
            Flight flight = new Flight(i, descriptionString, fromAirportString, toAirportString, FlighStatus.ONTIME);
            flightRepository.saveAndFlush(flight);
        }
        return flightRepository.findAll();
    }

    @GetMapping("/retrieving")
    public List<Flight> getListOfFlight() {
        return flightRepository.findAll();
    }
    @GetMapping("/retrieving/ontime")
    public List<Flight> findByStatusOnTime() {return flightRepository.flighStatus(FlighStatus.ONTIME);}
}