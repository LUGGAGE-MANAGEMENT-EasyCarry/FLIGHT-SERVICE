package com.example.luggagesystemflightapi.repository

import com.example.luggagesystemflightapi.domain.model.Flight
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FlightRepository  : JpaRepository<Flight,UUID>