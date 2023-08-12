package com.example.luggagesystemflightapi.consumer

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload


//todo notification api ekle
class FlightCreatedEventConsumer() {
    val logger = LoggerFactory.getLogger(FlightCreatedEvent::class.java)

    @KafkaListener(topicPattern = "flightCreated", groupId = "kafka-consumer")
    fun receiver(@Payload payload: FlightCreatedEvent) {
        logger.info("flight created")
       runBlocking {
 // notificationService
       }
    }
}