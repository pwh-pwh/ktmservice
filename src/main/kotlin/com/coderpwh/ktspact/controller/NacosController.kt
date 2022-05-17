package com.coderpwh.ktspact.controller

import org.springframework.web.bind.annotation.*


/**
 * @author coderpwh
 * @date 2022/5/17 3:40 PM
 */
@RestController
class NacosController {
    @GetMapping("/hi/nacos")
    fun hiNacos() = "hello nacos"
}