package br.com.challenge.productapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

    /*
    This configuration is used to enable CORS (Cross-Origin Resource Sharing) for the application.
    Commented for testing purposes, but can be uncommented when needed.
    — Guilherme Cavichioli (Project Developer)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // your Angular app origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

     */
}
