plugins {
    kotlin("jvm")
}

group = "com.example.domain"
version = "0.1.0"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
}

kotlin {
    jvmToolchain(21)
}