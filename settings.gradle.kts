rootProject.name = "bebra-cinema-backend"

include(":domain")
project(":domain").apply {
    projectDir = file("core/domain")
    buildFileName = "build.gradle.kts"
}

include(":application")
project(":application").apply {
    projectDir = file("core/application")
    buildFileName = "build.gradle.kts"
}

include(":postgresql-spring-data-jpa")
project(":postgresql-spring-data-jpa").apply {
    projectDir = file("data/postgresql-spring-data-jpa")
    buildFileName = "build.gradle.kts"
}

include(":output-port-adapter-spring-data-jpa")
project(":output-port-adapter-spring-data-jpa").apply {
    projectDir = file("data/output-port-adapter-spring-data-jpa")
    buildFileName = "build.gradle.kts"
}

include(":input-port-adapter-spring-webmvc")
project(":input-port-adapter-spring-webmvc").apply {
    projectDir = file("web/input-port-adapter-spring-webmvc")
    buildFileName = "build.gradle.kts"
}

include("security-jwt-spring-security")
project(":security-jwt-spring-security").apply {
    projectDir = file("web/security-jwt-spring-security")
    buildFileName = "build.gradle.kts"
}

include(":app")
