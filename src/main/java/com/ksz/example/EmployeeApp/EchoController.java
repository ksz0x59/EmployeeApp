package com.ksz.example.EmployeeApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EchoController {
    @RequestMapping("/echo")
    public String echo(@RequestParam(name = "message")
                               Optional<String> message)
    {
        return " Hi " + message.orElse("Anonymous") + " ! ";
    }
}
