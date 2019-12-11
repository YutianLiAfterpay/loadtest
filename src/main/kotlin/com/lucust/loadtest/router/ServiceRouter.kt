package com.lucust.loadtest.router

import com.lucust.loadtest.handler.HelloHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class ServiceRouter @Autowired constructor(
        private val helloHandler: HelloHandler
) {
    @Bean
    fun route(): RouterFunction<ServerResponse> {
        return route(GET("/hello"), helloHandler)
    }
}