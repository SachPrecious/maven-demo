package com.example.automation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam(required = true) String username) {
        // Simulating a potential security issue by concatenating user input directly into a SQL query
        String sqlQuery = "SELECT * FROM users WHERE username = '" + username + "'";
        // In a real application, use prepared statements or an ORM to prevent SQL injection

        return "Fetching user data using SQL query: " + sqlQuery;
    }
}
