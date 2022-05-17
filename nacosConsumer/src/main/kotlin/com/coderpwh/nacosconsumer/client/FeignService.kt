package com.coderpwh.nacosconsumer.client

import org.springframework.cloud.openfeign.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*


/**
 * @author coderpwh
 * @date 2022/5/17 3:59 PM
 */
@Component
@FeignClient(value = "myktsp")
interface FeignService {
    @GetMapping("/hi/nacos")
    fun hiNacos():String
}