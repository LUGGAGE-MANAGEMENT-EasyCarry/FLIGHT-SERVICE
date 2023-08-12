package com.example.luggagesystemflightapi.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties(prefix = "kafka.topics")
data class KafkaTopicProperties(val flightCreated:String )