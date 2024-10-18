plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.example"
version = "0.1.0"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        implementation(kotlin("stdlib"))
    }
}

dependencies {
}

kotlin {
    jvmToolchain(21)
}