package com.example.application.ports.inbound

import com.example.domain.entities.Product
import com.example.domain.enums.ProductName

interface CreateProductUseCase {
    suspend fun execute(product: Product) : Product
}

interface ReadAllProductsUseCase {
    suspend fun execute() : List<Product>
}

interface ReadProductByNameUseCase {
    suspend fun execute(name: ProductName) : Product?
}