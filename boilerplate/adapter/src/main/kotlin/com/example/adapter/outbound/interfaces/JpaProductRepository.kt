package com.example.adapter.outbound.interfaces

import com.example.adapter.outbound.entities.ProductEntity
import com.example.adapter.outbound.enums.ProductNameEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

interface JpaProductRepository: JpaRepository<ProductEntity, UUID> {
    fun findByName(name: ProductNameEntity): ProductEntity?
}