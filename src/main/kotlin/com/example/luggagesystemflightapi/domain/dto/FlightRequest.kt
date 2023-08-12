package com.example.luggagesystemflightapi.domain.dto

import java.time.LocalDate
import java.util.UUID

data class FlightRequest (val flightId: UUID?=null, var pnrCode:String, var flightDate: LocalDate, var departureLocation:String, var phoneNumber:Int)
