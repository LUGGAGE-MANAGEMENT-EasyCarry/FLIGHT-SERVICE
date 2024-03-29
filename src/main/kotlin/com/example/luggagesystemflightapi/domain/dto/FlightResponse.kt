package com.example.luggagesystemflightapi.domain.dto

import java.util.UUID

data class FlightResponse(var flightId: UUID?=null, var pnrCode:String, var flightDate: String, var departureLocation:String, var phoneNumber:Int)