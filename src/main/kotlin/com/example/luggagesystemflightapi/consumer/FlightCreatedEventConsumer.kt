package com.example.luggagesystemflightapi.consumer

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class FlightCreatedEventConsumer() {

    @KafkaListener(topicPattern = "flightCreated", groupId = "kafka-consumer")
    fun receiver(payload: FlightCreatedEvent) {
       println("$payload")
    }
}