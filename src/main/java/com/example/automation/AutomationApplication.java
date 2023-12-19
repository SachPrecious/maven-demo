package com.example.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class AutomationApplication {

    @GetMapping("/welcome")
    public String message() {
        return "Welcome to Automation World!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/greet")
    public String greetWithPost(@RequestParam String name) {
        return "Hello (POST), " + name + "!";
    }

    @GetMapping("/square/{number}")
    public int square(@PathVariable int number) {
        return number * number;
    }

    // You can create service classes and use them in your controller
    // For example:
    // @Autowired
    // private MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(AutomationApplication.class, args);
    }
}
