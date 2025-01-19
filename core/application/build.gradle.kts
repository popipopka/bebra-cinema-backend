plugins {

}

dependencies {
    implementation(project(":domain"))

    implementation("jakarta.validation:jakarta.validation-api")

    implementation("org.mapstruct:mapstruct")
    implementation("org.projectlombok:lombok-mapstruct-binding")

    annotationProcessor("org.mapstruct:mapstruct-processor")
}
