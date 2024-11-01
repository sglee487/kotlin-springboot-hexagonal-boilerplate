package com.example.application.services

import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.application.ports.outbound.ProductPort
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import org.springframework.stereotype.Service

@Service
class CreateProductService(private val productPort: ProductPort) : CreateProductUseCase {
    override suspend fun execute(product: Product): Product {
        return productPort.add(product)
    }
}

@Service
class ReadAllProductsService(private val productPort: ProductPort) : ReadAllProductsUseCase {
    override suspend fun execute(): List<Product> {
        return productPort.getAll()
    }
}

@Service
class ReadProductByNameService(private val productPort: ProductPort) : ReadProductByNameUseCase {
    override suspend fun execute(name: ProductName): Product? {
        return productPort.getByName(name)
    }
}