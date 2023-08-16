package com.example.luggagesystemflightapi.producer

import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class FlightCreatedEventProducer(private val kafkaTemplate: KafkaTemplate<String, FlightCreatedEvent>) {

    fun send(payload: FlightCreatedEvent) {
        val topic = "luggageCreated"
        kafkaTemplate.send(topic, payload)
    }
}