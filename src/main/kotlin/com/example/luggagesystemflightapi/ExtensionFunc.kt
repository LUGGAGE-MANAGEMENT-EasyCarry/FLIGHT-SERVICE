package com.example.luggagesystemflightapi

import org.slf4j.LoggerFactory


fun <T : Any> T.logger() = lazy { LoggerFactory.getLogger(javaClass) }
