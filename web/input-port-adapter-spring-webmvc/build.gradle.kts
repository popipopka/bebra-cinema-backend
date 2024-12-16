import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":security-spring-security"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
}
