package com.example.adapter.inbound.rest

import com.example.adapter.inbound.rest.dto.ProductRequestDTO
import com.example.application.ports.inbound.CreateProductUseCase
import com.example.application.ports.inbound.ReadAllProductsUseCase
import com.example.application.ports.inbound.ReadProductByNameUseCase
import com.example.domain.enums.ProductName
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
//    private val readAllProductsUseCase: ReadAllProductsUseCase,
//    private val readProductByNameUseCase: ReadProductByNameUseCase
) {
    private val logger = LoggerFactory.getLogger(ProductController::class.java)
    @PostMapping
    suspend fun postProduct(@RequestBody requestDTO: ProductRequestDTO) {
        logger.info("Received request to create product: $requestDTO")
        println("Received request to create product: $requestDTO")
        createProductUseCase.execute(requestDTO.toDomain())
    }

//    @GetMapping
//    suspend fun getAllProducts() {
//        readAllProductsUseCase.execute()
//    }
//
//    @GetMapping("/{name}")
//    suspend fun getProductByName(@PathVariable name: String) {
//        readProductByNameUseCase.execute(ProductName.valueOf(name))
//    }
}