import com.google.protobuf.gradle.*

plugins {
    idea
    id("com.google.protobuf")
}

version = "1.0"

dependencies {
    compileOnly("com.google.protobuf:protobuf-java:3.13.0")
    compileOnly("io.grpc:grpc-stub:1.33.0")
    compileOnly("io.grpc:grpc-protobuf:1.33.0")
}

idea {
    module {
        sourceDirs.plusAssign(file("${projectDir}/src/generated/main/java"));
        sourceDirs.plusAssign(file("${projectDir}/src/generated/main/grpc"));
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.13.0"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.33.0"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
    generatedFilesBaseDir = "$projectDir/src/generated"
}

tasks.withType<Delete> {
    doFirst {
        delete("$projectDir/src/generated")
    }
}