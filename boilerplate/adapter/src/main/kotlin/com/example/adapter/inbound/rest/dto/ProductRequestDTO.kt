package com.example.adapter.inbound.rest.dto

import com.example.domain.entities.Product

data class ProductRequestDTO(
    val name: String
){
    fun toDomain() = Product(
        name = com.example.domain.enums.ProductName.valueOf(name)
    )
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
