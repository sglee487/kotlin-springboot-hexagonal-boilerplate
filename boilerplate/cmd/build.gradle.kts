plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.cmd"
version = "0.1.0"

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":adapter"))
    implementation(project(":infrastructure"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

kotlin {
    jvmToolchain(21)
}