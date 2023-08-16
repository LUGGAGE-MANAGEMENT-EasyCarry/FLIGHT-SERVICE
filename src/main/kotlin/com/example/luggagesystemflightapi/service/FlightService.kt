package com.example.luggagesystemflightapi.service

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import com.example.luggagesystemflightapi.domain.model.Flight
import com.example.luggagesystemflightapi.producer.FlightCreatedEventProducer
import com.example.luggagesystemflightapi.repository.FlightRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class FlightService(private val flightCreatedEventProducer: FlightCreatedEventProducer,private val flightRepository: FlightRepository) {
    suspend fun getFlights(): List<Flight> {
        return flightRepository.findAll().toList()
    }

    suspend fun createFlight(flight: Flight): Flight {
        flightCreatedEventProducer.send(FlightCreatedEvent(flightId = flight.flightId, info = "Data"))
        return flightRepository.save(flight)

    }
}
