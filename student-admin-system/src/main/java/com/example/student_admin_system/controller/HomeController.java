package com.example.student_admin_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/welcome")
    public String home() {
        return "Welcome to the Student Admin System!";
    }
}


