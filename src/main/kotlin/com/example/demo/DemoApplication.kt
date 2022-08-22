package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [
        WebSocketServletAutoConfiguration::class,
        OAuth2ResourceServerAutoConfiguration::class,
        SecurityAutoConfiguration::class,
        UserDetailsServiceAutoConfiguration::class,
    ],
)
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
