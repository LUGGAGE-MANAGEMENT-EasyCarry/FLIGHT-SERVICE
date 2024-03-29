package com.example.luggagesystemflightapi.domain.dto

import java.time.LocalDate

data class FlightRequest (var pnrCode:String, var flightDate: LocalDate, var departureLocation:String, var phoneNumber:Int)
