package com.rinto.shop.dto

import com.rinto.shop.entity.Item

class ItemDTO private constructor(
    val id: Int,
    val name: String,
    val price: Int
) {
    constructor(item: Item) : this(item.id, item.name, item.price)
}