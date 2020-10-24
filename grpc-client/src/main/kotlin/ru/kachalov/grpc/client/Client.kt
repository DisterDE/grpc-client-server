package ru.kachalov.grpc.client

import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import ru.kachalov.grpc.client.components.GrpcClient

@SpringBootApplication
class Client(private val grpcClient: GrpcClient) : CommandLineRunner {

    override fun run(vararg args: String?) {
        grpcClient.start()
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(Client::class.java)
        .bannerMode(Banner.Mode.OFF)
        .run(*args)
}