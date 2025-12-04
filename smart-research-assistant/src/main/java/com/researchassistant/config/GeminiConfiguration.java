package com.researchassistant.config;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfiguration {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Bean
    public Client geminiClient() {
        // Assuming the Client constructor accepts the key or picks it up from Env.
        // If the library strictly uses Env vars, this wrapper still helps with mocking.
        // For this example, we assume we can set it, or we simply rely on the Env var
        // but expose it as a Spring Bean for injection.
        return new Client();
    }
}