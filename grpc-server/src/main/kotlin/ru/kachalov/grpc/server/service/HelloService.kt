package ru.kachalov.grpc.server.service

import io.grpc.stub.StreamObserver
import mu.KotlinLogging
import org.lognet.springboot.grpc.GRpcService
import ru.kachalov.grpc.proto.HelloRequest
import ru.kachalov.grpc.proto.HelloResponse
import ru.kachalov.grpc.proto.HelloServiceGrpc

@GRpcService
class HelloService : HelloServiceGrpc.HelloServiceImplBase() {

    private val log = KotlinLogging.logger { }

    override fun processMessage(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        val requestMessage = request.requestMessage
        log.info { "Received from client: $requestMessage" }
        val responseMessage = "$requestMessage\nFrom server with love!"
        val responseBuilder = HelloResponse.newBuilder()
        responseBuilder.responseMessage = responseMessage
        log.info { "Sent to client: $responseMessage" }
        responseObserver.onNext(responseBuilder.build())
        responseObserver.onCompleted()
    }
}