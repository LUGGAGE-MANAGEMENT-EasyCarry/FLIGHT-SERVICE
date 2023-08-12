package com.example.luggagesystemflightapi.controller

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.dto.FlightResponse
import com.example.luggagesystemflightapi.domain.mapper.FlightResponseMapper
import com.example.luggagesystemflightapi.service.FlightService
import org.mapstruct.factory.Mappers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/flights")
class FlightController(private val flightService: FlightService) {

    @GetMapping
    suspend fun getFlights(): List<FlightResponse> {
        val converter = Mappers.getMapper(FlightResponseMapper::class.java)
        return converter.convertListToDtoList(flightService.getFlights())
    }

    @PostMapping("/create")
    suspend fun createFlight(@RequestBody flightRequest: FlightRequest): FlightResponse {
        val converter = Mappers.getMapper(FlightResponseMapper::class.java)
        val savedFlight = flightService.createFlight(converter.convertDtoToEntity(flightRequest))
        return converter.convertDto(savedFlight)
    }

}