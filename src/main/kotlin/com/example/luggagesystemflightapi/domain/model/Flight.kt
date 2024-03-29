package com.example.luggagesystemflightapi.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table
data class Flight(@Id val flightId:UUID?=null, var pnrCode:String, var flightDate: String, var departureLocation:String, var phoneNumber:Int)
