plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":postgresql-spring-data-jpa"))
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":security-jwt-spring-security"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.mapstruct:mapstruct")
    implementation("org.projectlombok:lombok-mapstruct-binding")

    annotationProcessor("org.mapstruct:mapstruct-processor")
}
