package com.example.adapter.outbound.repositories

import com.example.adapter.outbound.interfaces.JpaProductRepository
import com.example.adapter.outbound.mappers.toDomain
import com.example.adapter.outbound.mappers.toEntity
import com.example.application.ports.outbound.ProductPort
import com.example.domain.entities.Product
import com.example.domain.enums.ProductName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Repository
import java.util.*

// 여기를 구성하는 것 자체가 이미 infrastructure 에 사용할 port의 인스턴스를 구성하는 것.

// jpa의 경우 impl은 infrastructure에 구성해야 하겠지만 spring jpa가 알아서 만들어준다.
@Repository
class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository,
) : ProductPort {
    override suspend fun add(product: Product): Product =
        withContext(Dispatchers.IO) {
            jpaProductRepository.save(product.toEntity())
        }.toDomain()


    override suspend fun getAll(): List<Product> =
        jpaProductRepository.findAll()
            .map { it.toDomain() }


    override suspend fun getById(id: UUID): Product? =
        withContext(Dispatchers.IO) {
            jpaProductRepository.findById(id)
        }.orElse(null)?.toDomain()


    override suspend fun getByName(name: ProductName): Product? =
        withContext(Dispatchers.IO) {
            jpaProductRepository.findByName(name.toEntity())
        }?.toDomain()


    override suspend fun set(product: Product): Product =
        withContext(Dispatchers.IO) {
            jpaProductRepository.save(product.toEntity())
        }.toDomain()


    override suspend fun removeById(id: UUID): Product? = withContext(Dispatchers.IO) {
        var entity = jpaProductRepository.findById(id).orElse(null)?.toDomain()
        jpaProductRepository.deleteById(id)
        return@withContext entity
    }
}
