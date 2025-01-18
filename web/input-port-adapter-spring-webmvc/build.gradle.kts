plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":security-jwt-spring-security"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.mapstruct:mapstruct")
    implementation("org.projectlombok:lombok-mapstruct-binding")

    annotationProcessor("org.mapstruct:mapstruct-processor")
}
