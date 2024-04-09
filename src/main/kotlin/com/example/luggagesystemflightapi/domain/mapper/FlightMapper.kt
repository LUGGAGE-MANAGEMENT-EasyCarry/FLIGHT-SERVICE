package com.example.luggagesystemflightapi.domain.mapper

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.dto.FlightResponse
import com.example.luggagesystemflightapi.domain.model.Flight
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface FlightMapper {
    @Mapping(source = "id", target = "flightId")
    fun toFlightResponse(flight: Flight):FlightResponse

    @Mapping(source = "flightId", target = "id")
     fun map(flights: List<Flight>):List<FlightResponse>

     @Mapping(target = "id", ignore = true)
     fun toFlight(flightRequest: FlightRequest):Flight
}