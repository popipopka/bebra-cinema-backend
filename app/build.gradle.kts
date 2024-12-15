plugins {
    id("org.springframework.boot")
}


dependencies {
    implementation(project(":application"))
    implementation(project(":postgresql-spring-data-jpa"))
    implementation(project(":output-port-adapter-spring-data-jpa"))
    implementation(project(":input-port-adapter-spring-webmvc"))
    implementation(project(":security-spring-security"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
}
