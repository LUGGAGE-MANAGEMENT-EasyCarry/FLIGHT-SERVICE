package com.example.luggagesystemflightapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@ConfigurationPropertiesScan
class LuggageSystemFlightApiApplication

fun main(args: Array<String>) {
    runApplication<LuggageSystemFlightApiApplication>(*args)
}
