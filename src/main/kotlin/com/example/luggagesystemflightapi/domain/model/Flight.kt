package com.example.luggagesystemflightapi.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.Date
import java.util.UUID

@Table
data class Flight(@Id val flightId:UUID?=null, val pnrCode:String, val  flightDate: LocalDate, val departureLocation:String, val phoneNumber:Int)
