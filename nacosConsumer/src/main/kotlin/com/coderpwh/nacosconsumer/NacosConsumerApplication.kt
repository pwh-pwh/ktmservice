package com.coderpwh.nacosconsumer

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.cloud.client.discovery.*
import org.springframework.cloud.openfeign.*

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class NacosConsumerApplication

fun main(args: Array<String>) {
    runApplication<NacosConsumerApplication>(*args)
}
