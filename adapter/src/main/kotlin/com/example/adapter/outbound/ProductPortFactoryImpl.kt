package com.example.adapter.outbound

import com.example.application.ports.outbound.ProductPort
import com.example.application.ports.outbound.ProductPortFactory
import org.springframework.stereotype.Component

@Component
class ProductPortFactoryImpl(
    private val productRepositoryImpl: ProductRepositoryImpl,
//    private val anotherProductRepositoryImpl: AnotherProductRepositoryImpl
) : ProductPortFactory {
    override fun getProductPort(type: String): ProductPort {
        return when (type) {
            "impl1" -> productRepositoryImpl
//            "impl2" -> anotherProductRepositoryImpl
            else -> throw IllegalArgumentException("Unknown implementation type")
        }
    }
}