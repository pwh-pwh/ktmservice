package com.coderpwh.ktspact

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.cloud.client.discovery.*

@SpringBootApplication
@EnableDiscoveryClient
class KtspactApplication

fun main(args: Array<String>) {
    runApplication<KtspactApplication>(*args)
}
