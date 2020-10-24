package ru.kachalov.grpc.client.components

import io.grpc.netty.NettyChannelBuilder
import io.grpc.stub.StreamObserver
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.kachalov.grpc.proto.HelloRequest
import ru.kachalov.grpc.proto.HelloResponse
import ru.kachalov.grpc.proto.HelloServiceGrpc
import java.util.*

@Component
class GrpcClient(
    @Value("\${service.host}")
    private val host: String,
    @Value("\${service.port}")
    private val port: Int
) {

    private val log = KotlinLogging.logger { }

    fun start() {
        val scanner = Scanner(System.`in`)
        val channel = NettyChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build()
        val asyncClient = HelloServiceGrpc.newStub(channel)

        while (true) {
            if (!scanner.hasNextLine()) {
                continue
            }
            val input = scanner.nextLine()

            log.info {
                "Received from user: \"$input\"" +
                        "\n Creating request."
            }

            val requestBuilder = HelloRequest.newBuilder()
            val requestMessage = "Request from client: $input"
            requestBuilder.requestMessage = requestMessage

            asyncClient.processMessage(requestBuilder.build(), object : StreamObserver<HelloResponse> {
                override fun onNext(value: HelloResponse) {
                    log.info {
                        "Received from server: ${value.responseMessage}"
                    }
                }

                override fun onError(t: Throwable?) {
                    log.warn(t) {
                        "Error from server: "
                    }
                }

                override fun onCompleted() {
                    log.info { "Stream completed." }
                }
            })
        }
    }
}