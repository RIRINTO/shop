package com.rinto.shop.dto

import com.rinto.shop.entity.Item

data class ItemSaveRequestDTO(
    val name: String,
    val price: Int
) {
    fun toEntity() =
        Item(
            name, price
        )
}