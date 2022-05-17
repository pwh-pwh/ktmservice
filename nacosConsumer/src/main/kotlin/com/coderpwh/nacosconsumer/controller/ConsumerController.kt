package com.coderpwh.nacosconsumer.controller

import com.coderpwh.nacosconsumer.client.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*


/**
 * @author coderpwh
 * @date 2022/5/17 4:05 PM
 */
@RestController
class ConsumerController {
    @Autowired
    lateinit var feignService: FeignService

    @GetMapping("/feign/nacos")
    fun getFeignRs():String {
        return feignService.hiNacos()
    }
}