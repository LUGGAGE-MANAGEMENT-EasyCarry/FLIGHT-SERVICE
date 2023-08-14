package com.example.luggagesystemflightapi.utils

import com.example.luggagesystemflightapi.domain.dto.FlightRequest
import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import com.example.luggagesystemflightapi.domain.model.Flight
import java.time.LocalDate
import java.util.UUID

fun getFlight(
    flightId: UUID = UUID.fromString("4aa78416-2f33-42b6-9f17-6d8b9e474174"),
    pnrCode: String = "AS2131",
    flightDate: LocalDate = LocalDate.parse("2014-05-06"),
    departureLocation: String = "paris",
    phoneNumber: Int = 12345
): Flight {
    return Flight(flightId, pnrCode, flightDate, departureLocation, phoneNumber)
}

fun createFlightRequest(
    flightId: UUID = UUID.fromString("4aa78416-2f33-42b6-9f17-6d8b9e474174"),
    pnrCode: String = "AS2131",
    flightDate: LocalDate = LocalDate.parse("2014-05-06"),
    departureLocation: String = "paris",
    phoneNumber: Int = 12345
): FlightRequest {
    return FlightRequest(flightId, pnrCode, flightDate, departureLocation, phoneNumber)
}

fun flightCreatedEvent(flightId: UUID = UUID.fromString("4aa78416-2f33-42b6-9f17-6d8b9e474174")): FlightCreatedEvent {
    return FlightCreatedEvent(flightId)
}