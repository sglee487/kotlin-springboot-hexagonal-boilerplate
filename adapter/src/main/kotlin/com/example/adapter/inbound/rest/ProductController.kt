package com.example.adapter.inbound.rest

import com.example.adapter.inbound.rest.dto.ProductRequestDTO
import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.domain.enums.ProductName
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val readAllProductsUseCase: ReadAllProductsUseCase,
    private val readProductByNameUseCase: ReadProductByNameUseCase
) {
    @PostMapping
    suspend fun postProduct(@RequestBody requestDTO: ProductRequestDTO) {
        createProductUseCase.execute(requestDTO.toDomain())
    }

    @GetMapping
    suspend fun getAllProducts() {
        readAllProductsUseCase.execute()
    }

    @GetMapping("/{name}")
    suspend fun getProductByName(@PathVariable name: String) {
        readProductByNameUseCase.execute(ProductName.valueOf(name))
    }
}