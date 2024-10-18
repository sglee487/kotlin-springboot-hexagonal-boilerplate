plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.cmd"
version = "0.1.0"

dependencies {
    compileOnly(project(":domain"))
    compileOnly(project(":application"))
    compileOnly(project(":adapter"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}