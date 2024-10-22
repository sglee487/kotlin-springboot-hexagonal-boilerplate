package com.example.adapter.outbound.entities

import com.example.adapter.outbound.enums.ProductNameEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "products")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    var name: ProductNameEntity = ProductNameEntity.MY_PRODUCT
) {
}