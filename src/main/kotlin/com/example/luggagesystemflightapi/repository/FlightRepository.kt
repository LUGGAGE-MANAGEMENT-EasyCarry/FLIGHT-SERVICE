package com.example.luggagesystemflightapi.repository

import com.example.luggagesystemflightapi.domain.model.Flight
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface FlightRepository  : CoroutineCrudRepository<Flight,UUID> {

}