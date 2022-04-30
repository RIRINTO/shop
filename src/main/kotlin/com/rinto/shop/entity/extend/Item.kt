@file:JvmName("Item")

package com.rinto.shop.entity.extend

import com.rinto.shop.dto.ItemChangeRequestDTO
import com.rinto.shop.entity.Item

fun Item.update(itemChangeRequestDTO: ItemChangeRequestDTO) {
    this.name = itemChangeRequestDTO.name
    this.price = itemChangeRequestDTO.price
}