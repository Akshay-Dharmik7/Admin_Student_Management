package com.example.student_admin_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable())  // Disable CSRF (for demonstration purposes)
        .authorizeRequests(authorize -> authorize
            .antMatchers("/", "/login", "/error").permitAll()   // Allow access to root, login, and error pages
            .antMatchers("/admin/**").hasRole("ADMIN")          // Only ADMIN role can access /admin/**
            .antMatchers("/student/**").hasRole("STUDENT")      // Only STUDENT role can access /student/**
            .anyRequest().authenticated()                       // All other requests must be authenticated
        )
        .formLogin(login -> login
            .loginPage("/login")                                // Specify a custom login page URL
            .permitAll()                                        // Allow everyone to see the login page
        )
        .logout(logout -> logout
            .permitAll()                                        // Allow everyone to use the logout function
        );

    return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
