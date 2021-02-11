package ru.kachalov.grpc.client

import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.kachalov.grpc.client.components.GrpcClient

@SpringBootApplication
class Client(private val grpcClient: GrpcClient) : CommandLineRunner {

    override fun run(vararg args: String?) {
        grpcClient.start()
    }
}

fun main() {
    runApplication<Client>() {
        setBannerMode(Banner.Mode.OFF)
    }
}