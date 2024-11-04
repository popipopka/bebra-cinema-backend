rootProject.name = "bebra-cinema-backend"

include(":domain")
project(":domain").apply {
    projectDir = file("core/domain")
    buildFileName = "build.gradle.kts"
}
