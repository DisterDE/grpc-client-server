plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":protobuf-api"))

    implementation("com.google.protobuf:protobuf-java:3.13.0")

    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE") {
        exclude("org.springframework.boot:spring-boot-starter-json")
    }

    implementation("io.grpc:grpc-netty:1.33.0")
    implementation("io.grpc:grpc-stub:1.33.0")
    implementation("io.grpc:grpc-protobuf:1.33.0")

    implementation("io.github.microutils:kotlin-logging:1.12.0")
}

springBoot {
    mainClassName = "ru.kachalov.grpc.client.ClientKt"
}