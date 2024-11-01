plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.adapter"
version = "0.1.0"


dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.data:spring-data-r2dbc")

    // request body json null handling
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

kotlin {
    jvmToolchain(21)
}