package com.example.student_admin_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin.html";
    }

    @PostMapping("/register")
    public String registerStudent(@RequestParam String name, @RequestParam String address, @RequestParam String subjects) {
        // Handle student registration logic
        // e.g., save to database
        return "redirect:/";
    }
}
