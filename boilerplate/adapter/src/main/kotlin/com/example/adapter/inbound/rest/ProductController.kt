package com.example.adapter.inbound.rest

import com.example.adapter.inbound.rest.dto.ProductRequestDTO
import com.example.adapter.inbound.rest.dto.ProductResponseDTO
import com.example.adapter.inbound.rest.dto.toResponseDTO
import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.domain.enums.ProductName
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val readAllProductsUseCase: ReadAllProductsUseCase,
    private val readProductByNameUseCase: ReadProductByNameUseCase
) {
    private val logger = LoggerFactory.getLogger(ProductController::class.java)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    suspend fun postProduct(@RequestBody requestDTO: ProductRequestDTO): ProductResponseDTO {
        logger.info("Received request to create product: $requestDTO")
        return createProductUseCase.execute(requestDTO.toDomain()).toResponseDTO()
    }

    @GetMapping
    suspend fun getAllProducts(): List<ProductResponseDTO> {
        return readAllProductsUseCase.execute().map { it.toResponseDTO() }
    }
//
    @GetMapping("/{name}")
    suspend fun getProductByName(@PathVariable name: String): ProductResponseDTO? {
        return readProductByNameUseCase.execute(ProductName.valueOf(name))?.toResponseDTO()
    }
}