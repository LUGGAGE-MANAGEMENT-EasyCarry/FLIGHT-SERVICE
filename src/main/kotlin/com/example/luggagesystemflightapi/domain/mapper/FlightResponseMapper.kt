package com.example.luggagesystemflightapi.domain.mapper

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.dto.FlightResponse
import com.example.luggagesystemflightapi.domain.model.Flight
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface FlightResponseMapper {

    fun convertDto(flight: Flight):FlightResponse
     fun convertListToDtoList(flights: List<Flight>):List<FlightResponse>
     fun convertDtoToEntity(flightRequest: FlightRequest):Flight
}