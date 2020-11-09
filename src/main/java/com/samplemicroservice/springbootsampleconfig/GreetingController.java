package com.samplemicroservice.springbootsampleconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: Default Value}")
    private String greetingMessage;

    @Value("Some Static Message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValue;

    @Value("#{${dbValues}}")
    private Map<String,String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment env;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage + dbSettings.getConnection()+ dbSettings.getHost();
    }

    @GetMapping("/envDetails")
    public String envDetails(){
    return env.toString();
    }
}
