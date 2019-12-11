package com.lucust.loadtest.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HelloHandler : HandlerFunction<ServerResponse> {
    private var numberOfRequests = 0
    override fun handle(request: ServerRequest): Mono<ServerResponse> {
        numberOfRequests = numberOfRequests.inc()
        println("Received request numbers - $numberOfRequests")
        return Mono.just(request).then(ServerResponse.ok().bodyValue("Hello, World"))
    }
}
