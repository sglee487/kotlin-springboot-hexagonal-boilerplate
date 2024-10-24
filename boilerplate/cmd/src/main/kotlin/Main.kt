package com.example.cmd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.example"])
@EnableJpaRepositories(basePackages = ["com.example.adapter.outbound.interfaces"])
@EntityScan(basePackages = ["com.example.adapter.outbound.entities"])
@ComponentScan(basePackages = ["com.example"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}