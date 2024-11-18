rootProject.name = "bebra-cinema-backend"

include(":domain")
project(":domain").apply {
    projectDir = file("core/domain")
    buildFileName = "build.gradle.kts"
}

include(":usecase")
project(":usecase").apply {
    projectDir = file("core/usecase")
    buildFileName = "build.gradle.kts"
}

include(":database")
project(":database").apply {
    projectDir = file("data/database")
    buildFileName = "build.gradle.kts"
}