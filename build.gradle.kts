import org.springframework.boot.gradle.tasks.bundling.BootJar

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
        dependencies {
            dependencySet("org.mapstruct:1.5.5.Final") {
                entry("mapstruct")
                entry("mapstruct-processor")
            }

            dependency("org.projectlombok:lombok:1.18.36")

            dependency("org.projectlombok:lombok-mapstruct-binding:0.2.0")
        }
    }

    dependencies {
        annotationProcessor("org.projectlombok:lombok")

        compileOnly("org.projectlombok:lombok")
    }
}
