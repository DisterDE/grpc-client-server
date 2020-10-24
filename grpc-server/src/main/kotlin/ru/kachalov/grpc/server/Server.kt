package ru.kachalov.grpc.server

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class Server

fun main(args: Array<String>) {
    SpringApplicationBuilder(Server::class.java)
        .bannerMode(Banner.Mode.OFF)
        .run(*args)
}