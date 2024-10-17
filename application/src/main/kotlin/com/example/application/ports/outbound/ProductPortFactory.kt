package com.example.application.ports.outbound

interface ProductPortFactory {
    fun getProductPort(type: String): ProductPort
}