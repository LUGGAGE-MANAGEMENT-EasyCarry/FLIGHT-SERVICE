package com.example.luggagesystemflightapi.controller

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.dto.FlightResponse
import com.example.luggagesystemflightapi.service.FlightService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/flights")
class FlightController(private val flightService: FlightService) {

    @GetMapping
     fun getFlights(): List<FlightResponse> {
        return flightService.getFlights()
    }

    @PostMapping
     fun createFlight(@RequestBody flightRequest: FlightRequest): ResponseEntity<FlightResponse> {
        val createdFlight = flightService.createFlight(flightRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight)
    }

    @GetMapping("/{id}")
    fun deleteFlight(@PathVariable id: UUID) {
        flightService.deleteFlight(id)
    }

}