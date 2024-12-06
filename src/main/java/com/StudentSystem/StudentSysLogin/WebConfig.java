package com.StudentSystem.StudentSysLogin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://127.0.0.1:5500", "http://localhost:3000") // Update as per your frontend's origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH"); // Allow required methods
    }
}

