package com.rinto.shop.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Table
@Entity
data class Item(
    val name: String,

    val price: Int
) {
    @Id
    @GeneratedValue
    var id: Int = 0
}