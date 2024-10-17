package com.example.domain.entities

import com.example.domain.enums.ProductName
import java.util.UUID

data class Product(
    val id: UUID? = null,
    val name: ProductName = ProductName.MY_PRODUCT
) {
}