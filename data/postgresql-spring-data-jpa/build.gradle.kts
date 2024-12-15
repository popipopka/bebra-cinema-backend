plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")

    runtimeOnly("org.postgresql:postgresql")
}
