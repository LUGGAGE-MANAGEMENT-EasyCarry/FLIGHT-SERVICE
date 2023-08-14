package com.example.luggagesystemflightapi.service

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import com.example.luggagesystemflightapi.domain.model.Flight
import com.example.luggagesystemflightapi.producer.FlightCreatedEventProducer
import com.example.luggagesystemflightapi.repository.FlightRepository

import com.example.luggagesystemflightapi.utils.createFlightRequest
import com.example.luggagesystemflightapi.utils.flightCreatedEvent
import com.example.luggagesystemflightapi.utils.getFlight
import io.mockk.Runs
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.lang.RuntimeException
import java.util.UUID

@SpringBootTest
class FlightServiceTest {

    //create once mockk
    val flightRepository = mockk<FlightRepository>()
    val flightCreatedEventProducer = mockk<FlightCreatedEventProducer>()
    private val flightService = FlightService(flightCreatedEventProducer, flightRepository)


    @BeforeEach
    fun setUp() {
        clearMocks(flightRepository)
        //create once reset after all tests for fast
    }

    //all type of tests are divided get design post design delete design to make code readable
    @Nested
    inner class GetDesign {

        @Test
        fun `when flightService#getFlights is null it should throws RuntimeException `() = runBlocking {
//Given
            coEvery { flightRepository.findAll() } throws RuntimeException("Flights are not found")
            assertThrows<RuntimeException> {
                flightService.getFlights()
            }
            coVerify { flightRepository.findAll() }

        }

        /*  @Test
          fun `when flightService#getFlights it should return correctly flights `() = runBlocking {
  //Given
              val flightsFlow = getFlight()
              val expected= getFlight()

              every { flightRepository.findAll() } returns expected

              val actual = flightService.getFlights().asFlow()
              assertEquals(expected, actual)

          }*/
    }

    @Nested
    inner class PostDesign {
        @Test
        fun `when flightService#createFlight it should return correctly Flight `() = runBlocking {
            val createCustomerRequest = createFlightRequest()
            val flightCreatedEvent = flightCreatedEvent()

            val flightToSave = Flight(
                createCustomerRequest.flightId,
                createCustomerRequest.pnrCode,
                createCustomerRequest.flightDate,
                createCustomerRequest.departureLocation,
                createCustomerRequest.phoneNumber
            )
            coEvery { flightCreatedEventProducer.send(flightCreatedEvent) } just Runs
            coEvery { flightRepository.save(flightToSave) } returns getFlight()
            val expected = getFlight()
            val actual = flightService.createFlight(flightToSave)
            assertEquals(expected, actual)
            coVerify {
                flightRepository.save(flightToSave)
                flightCreatedEventProducer.send(flightCreatedEvent)
            }
        }

    }
}