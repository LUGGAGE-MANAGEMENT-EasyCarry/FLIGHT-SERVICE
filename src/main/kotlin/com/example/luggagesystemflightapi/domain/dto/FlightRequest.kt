package com.example.luggagesystemflightapi.domain.dto

data class FlightRequest (
        var pnrCode:String,
        var flightDate: String,
        var departureLocation:String,
        var phoneNumber:Int)
