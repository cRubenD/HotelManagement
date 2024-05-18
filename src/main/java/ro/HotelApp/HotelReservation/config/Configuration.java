package ro.HotelApp.HotelReservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:63342");
//                registry.addMapping("/**") // Allow CORS for all paths
//                        .allowedOrigins("*") // Allow all origins
//                        .allowedMethods("*") // Allow all HTTP methods
//                        .allowedHeaders("*") // Allow all headers
//                        .allowCredentials(true) // Allow credentials if needed
//                        .maxAge(3600); // Cache preflight response for 1 hour
            }
        };
    }
}

