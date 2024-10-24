package com.example.adapter.inbound.rest.dto

import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductRequestDTO(
    @JsonProperty("name")
    val name: String
) {
    fun toDomain(): Product {
        return Product(
            name = kotlin.runCatching { ProductName.fromValue(name) }.getOrElse {
                throw IllegalArgumentException("Invalid product name")
            }
        )
    }
}

data class ProductResponseDTO(
    val id: String,
    val name: String
){
    constructor(product: Product) : this(
        id = product.id.toString(),
        name = product.name.value
    )
}

fun Product.toResponseDTO() = ProductResponseDTO(this)
