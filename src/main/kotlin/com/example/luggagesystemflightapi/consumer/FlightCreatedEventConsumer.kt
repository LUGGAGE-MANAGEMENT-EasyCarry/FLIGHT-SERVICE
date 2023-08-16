package com.example.luggagesystemflightapi.consumer

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
//todo notification api ekle
class FlightCreatedEventConsumer() {

    @KafkaListener(topicPattern = "flightCreated", groupId = "kafka-consumer")
    fun receiver(@Payload payload: FlightCreatedEvent) {
       println(payload.info)
    }
}