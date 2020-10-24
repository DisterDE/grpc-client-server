plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
    id("org.springframework.boot")
}

version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":protobuf-api"))

    implementation("org.springframework.boot:spring-boot-starter-actuator:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE") {
        exclude("org.springframework.boot:spring-boot-starter-json:2.3.4.RELEASE")
    }

    implementation("io.github.lognet:grpc-spring-boot-starter:4.2.0")

    implementation("io.github.microutils:kotlin-logging:1.12.0")
}

springBoot {
    mainClassName = "ru.kachalov.grpc.server.ServerKt"
}