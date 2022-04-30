package com.rinto.shop.controller

import com.rinto.shop.service.ItemService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController(
    private val itemService: ItemService
) {
    val log:Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun main(): String {
        log.info("main 함수 진입")

        return "main"
    }
}