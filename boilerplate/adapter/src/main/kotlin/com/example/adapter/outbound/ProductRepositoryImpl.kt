package com.example.adapter.outbound

import com.example.application.ports.outbound.ProductPort
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import org.springframework.stereotype.Component

@Component
class ProductRepositoryImpl : ProductPort {
    override suspend fun add(product: Product): Product {
        // 실제 DB에 저장하는 로직 구현 (예: JPA, MongoDB 등)
        return product
    }

    override suspend fun getAll(): List<Product> {
        // DB에서 모든 제품을 가져오는 로직 구현
        return listOf()
    }

    override suspend fun getById(id: String): Product? {
        // ID로 제품을 가져오는 로직 구현
        return null
    }

    override suspend fun getByName(name: ProductName): Product? {
        // 이름으로 제품을 가져오는 로직 구현
        return null
    }

    override suspend fun set(product: Product): Product {
        // 제품 정보 업데이트 로직 구현
        return product
    }

    override suspend fun removeById(id: String): Product? {
        // ID로 제품을 삭제하는 로직 구현
        return null
    }
}
