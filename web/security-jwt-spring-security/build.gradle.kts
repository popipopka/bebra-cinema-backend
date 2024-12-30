plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api")
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("io.jsonwebtoken:jjwt-jackson")
    runtimeOnly("io.jsonwebtoken:jjwt-impl")
}
