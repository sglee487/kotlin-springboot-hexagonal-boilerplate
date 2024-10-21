package com.example.domain.enums

enum class ProductName(
    val value: String
) {
    MY_PRODUCT("My Product");

    companion object {
        fun fromValue(value: String): ProductName {
            return entries.find { it.value == value }
                ?: throw IllegalArgumentException("Unknown value: $value")
        }
    }
}
