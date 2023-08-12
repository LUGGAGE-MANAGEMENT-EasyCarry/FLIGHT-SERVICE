package com.example.luggagesystemflightapi.domain.dto

import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class FlightResponse(var flightId: UUID?=null, var pnrCode:String, var flightDate: LocalDate, var departureLocation:String, var phoneNumber:Int)