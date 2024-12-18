plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.application"
version = "0.1.0"

dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter")
}

kotlin {
    jvmToolchain(21)
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}