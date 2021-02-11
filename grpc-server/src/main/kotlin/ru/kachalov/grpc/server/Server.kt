package ru.kachalov.grpc.server

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Server

fun main() {
    runApplication<Server>() {
        setBannerMode(Banner.Mode.OFF)
    }
}