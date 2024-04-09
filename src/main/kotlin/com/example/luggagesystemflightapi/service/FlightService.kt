package com.example.luggagesystemflightapi.service

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.dto.FlightResponse
import com.example.luggagesystemflightapi.domain.mapper.FlightMapper
import com.example.luggagesystemflightapi.repository.FlightRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FlightService(
        private val repo: FlightRepository,
        private val mapper: FlightMapper
) {
     fun getFlights(): List<FlightResponse> {
        val flights = repo.findAll()
        return mapper.map(flights)
    }

     fun createFlight(request: FlightRequest): FlightResponse {
        val flight = mapper.toFlight(flightRequest = request)
        val savedFlight = repo.save(flight)
        return mapper.toFlightResponse(savedFlight)
    }

    fun deleteFlight(id:UUID){
        repo.findById(id).orElseThrow { throw RuntimeException("Exception") }
    }

}
