package com.example.domain.enums

import com.fasterxml.jackson.annotation.JsonCreator

enum class ProductName(
    val value: String
) {
    MY_PRODUCT("My Product");

    companion object {
        @JsonCreator
        @JvmStatic
        fun fromValue(value: String): ProductName {
            return entries.find { it.value.equals(value, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown value: $value")
        }
    }
}
