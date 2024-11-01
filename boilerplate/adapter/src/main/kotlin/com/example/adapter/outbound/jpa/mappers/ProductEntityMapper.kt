package com.example.adapter.outbound.jpa.mappers

import com.example.adapter.outbound.jpa.entities.ProductEntity
import com.example.adapter.outbound.jpa.enums.ProductNameEntity
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName

fun ProductNameEntity.toDomain() : ProductName = when(this) {
    ProductNameEntity.MY_PRODUCT -> ProductName.MY_PRODUCT
}

fun ProductName.toEntity() : ProductNameEntity = when(this) {
    ProductName.MY_PRODUCT -> ProductNameEntity.MY_PRODUCT
}

fun ProductEntity.toDomain() : Product = Product(
    id = this.id,
    name = this.name.toDomain()
)

fun Product.toEntity() : ProductEntity = ProductEntity(
    id = this.id,
    name = this.name.toEntity()
)