package com.rinto.shop.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Table
@Entity
data class Item(
    var name: String,

    var price: Int
) {
    @Id
    @GeneratedValue
    var id: Int = 0
}