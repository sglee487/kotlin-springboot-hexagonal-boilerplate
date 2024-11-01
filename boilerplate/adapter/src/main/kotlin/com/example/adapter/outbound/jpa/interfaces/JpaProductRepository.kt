package com.example.adapter.outbound.jpa.interfaces

import com.example.adapter.outbound.jpa.entities.ProductEntity
import com.example.adapter.outbound.jpa.enums.ProductNameEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaProductRepository: JpaRepository<ProductEntity, UUID> {
    fun findByName(name: ProductNameEntity): ProductEntity?
}