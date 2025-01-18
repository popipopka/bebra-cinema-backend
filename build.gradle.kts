plugins {
    id("java")
    id("org.springframework.boot") version "3.3.3" apply false
    id("io.spring.dependency-management") version "1.1.6"
}

allprojects {
    group = "it.bebra.cinema"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3")
        }

        dependencies {
            dependencySet("org.mapstruct:1.5.5.Final") {
                entry("mapstruct")
                entry("mapstruct-processor")
            }

            dependency("org.projectlombok:lombok-mapstruct-binding:0.2.0")

            dependencySet("io.jsonwebtoken:0.12.6") {
                entry("jjwt-api")
                entry("jjwt-impl")
                entry("jjwt-jackson")
            }
        }
    }

    dependencies {
        annotationProcessor("org.projectlombok:lombok")

        compileOnly("org.projectlombok:lombok")
    }
}
