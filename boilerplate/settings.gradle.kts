plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "boilerplate"
include("cmd")
include("domain")
include("application")
include("adapter")
include("infrastructure")
