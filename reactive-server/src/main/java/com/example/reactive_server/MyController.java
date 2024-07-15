package com.example.reactive_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/hello")
    public Mono<String> getMessage() {
        return computeMessage()
                .zipWith(getNameFromDB())
                .map((val) -> val.getT1() + " " + val.getT2());
    }

    private Mono<String> computeMessage() {
        return Mono.just("Hello").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> getNameFromDB() {
        return Mono.just("Manish").delayElement(Duration.ofSeconds(3));
    }
}
