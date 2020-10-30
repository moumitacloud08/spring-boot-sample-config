package com.samplemicroservice.springbootsampleconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greeting: Default Value}")
    private String greetingMessage;

    @Value("Some Static Message")
    private String staticMessage;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage;
    }
}
