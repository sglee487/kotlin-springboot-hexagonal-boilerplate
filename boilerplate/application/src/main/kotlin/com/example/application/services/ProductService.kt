package com.example.application.services

import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.application.ports.outbound.ProductPort
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import org.springframework.stereotype.Service

@Service
class ProductService(private val productPort: ProductPort) : CreateProductUseCase, ReadAllProductsUseCase, ReadProductByNameUseCase {
    override suspend fun execute(product: Product): Product {
        return productPort.add(product)
    }

    override suspend fun execute(): List<Product> {
        return productPort.getAll()
    }

    override suspend fun execute(name: ProductName): Product? {
        return productPort.getByName(name)
    }
}