package com.example.adapter.outbound.jpa.entities

import com.example.adapter.outbound.jpa.enums.ProductNameEntity
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