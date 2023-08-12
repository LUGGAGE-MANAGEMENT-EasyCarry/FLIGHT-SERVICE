package com.example.luggagesystemflightapi.producer

import com.example.luggagesystemflightapi.configuration.properties.KafkaTopicProperties
import com.example.luggagesystemflightapi.domain.event.FlightCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload

class FlightCreatedEventProducer(private val kafkaTopicProperties: KafkaTopicProperties, private val kafkaTemplate: KafkaTemplate<String, Any>) {

    val logger = LoggerFactory.getLogger(FlightCreatedEvent::class.java)

    fun send(@Payload payload: FlightCreatedEvent) {
        val topic = kafkaTopicProperties.flightCreated
        logger.info("topic : $topic , info :$payload")
        kafkaTemplate.send(topic, payload)
    }
}