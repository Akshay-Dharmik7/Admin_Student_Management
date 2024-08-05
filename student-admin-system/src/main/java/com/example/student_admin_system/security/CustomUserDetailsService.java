package com.example.student_admin_system.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demonstration, we are using hardcoded users. You should fetch users from the database.
        if ("admin".equals(username)) {
            return new User("admin", "$2a$10$DowJRMtGPKBn/vLZJHY7H.NvO9I8..5jxbUY8g7RQ1kU7DKQ/tVo2", new ArrayList<>()); // password: admin123
        } else if ("student".equals(username)) {
            return new User("student", "$2a$10$DowJRMtGPKBn/vLZJHY7H.NvO9I8..5jxbUY8g7RQ1kU7DKQ/tVo2", new ArrayList<>()); // password: student123
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
