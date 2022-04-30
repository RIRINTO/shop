package com.rinto.shop.controller

import com.rinto.shop.dto.ItemChangeRequestDTO
import com.rinto.shop.dto.ItemSaveRequestDTO
import com.rinto.shop.service.ItemService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MainController(
    private val itemService: ItemService
) {
    val log: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun main(model: Model): String {
        log.info("main 함수 진입")

        model.addAttribute("items", itemService.itemLists)

        return "main"
    }

    @GetMapping("create")
    fun create(): String {
        log.info("show create view")

        return "item/create"
    }

    @PostMapping("create")
    fun createSubmit(itemSaveRequestDTO: ItemSaveRequestDTO): String {
        log.info("submit data: {}", itemSaveRequestDTO)

        itemService.save(itemSaveRequestDTO)

        return "redirect:/"
    }

    @GetMapping("{itemId}")
    fun getItemInfo(@PathVariable itemId: Int, model: Model): String {
        model.addAttribute("item", itemService.getItem(itemId))

        return "item/details"
    }

    @PostMapping("{itemId}")
    fun editItem(@PathVariable itemId: Int, itemChangeRequestDTO: ItemChangeRequestDTO):String {
        itemService.editItem(itemId, itemChangeRequestDTO)
        return "redirect:/$itemId"
    }
}