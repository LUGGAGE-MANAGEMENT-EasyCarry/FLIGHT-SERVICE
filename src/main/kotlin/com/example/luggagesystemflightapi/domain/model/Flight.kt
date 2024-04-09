package com.example.luggagesystemflightapi.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "flight")
class Flight(

        @Id
        @GeneratedValue
        var id:UUID? = null,

        @Column(name = "pnr_code")
        var pnrCode:String,

        @Column(name = "flight_date")
        var flightDate: String,

        @Column(name = "departure_location")
        var departureLocation:String,

        @Column(name = "phone_number")
        var phoneNumber:String

)
