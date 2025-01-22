import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}


dependencies {
    implementation(project(":application"))
    implementation(project(":postgresql-spring-data-jpa"))
    implementation(project(":output-port-adapter-spring-data-jpa"))
    implementation(project(":input-port-adapter-spring-webmvc"))
    implementation(project(":security-jwt-spring-security"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks {
    named<BootJar>("bootJar") {
        layered {
            enabled = true
        }
        archiveFileName.set("bebra-cinema-app.jar")
        mainClass.set("it.bebra.cinema.app.BebraCinemaApplication")
    }

    named<Jar>("jar") {
        enabled = false
    }
}
