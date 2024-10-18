package com.example.application.ports.outbound

import com.example.domain.entities.Product
import com.example.domain.enums.ProductName

interface ProductPort {
    suspend fun add(product: Product): Product
    suspend fun getAll(): List<Product>
    suspend fun getById(id: String): Product?
    suspend fun getByName(name: ProductName): Product?
    suspend fun set(product: Product): Product
    suspend fun removeById(id: String) : Product?
}