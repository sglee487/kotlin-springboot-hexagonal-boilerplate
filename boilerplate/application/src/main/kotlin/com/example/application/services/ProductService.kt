package com.example.application.services

import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.application.ports.outbound.ProductPortFactory
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import org.springframework.stereotype.Service

@Service
class CreateProductService(private val productPortFactory: ProductPortFactory) : CreateProductUseCase {
    override suspend fun execute(product: Product): Product {
        val productRepository = productPortFactory.getProductPort("impl1")  // 동적 선택
        return productRepository.add(product)
    }
}

@Service
class ReadAllProductsService(private val productPortFactory: ProductPortFactory) : ReadAllProductsUseCase {
    override suspend fun execute(): List<Product> {
        val productRepository = productPortFactory.getProductPort("impl1")  // 동적 선택
        return productRepository.getAll()
    }
}

@Service
class ReadProductByNameService(private val productPortFactory: ProductPortFactory) : ReadProductByNameUseCase {
    override suspend fun execute(name: ProductName): Product? {
        val productRepository = productPortFactory.getProductPort("impl1")  // 동적 선택
        return productRepository.getByName(name)
    }
}