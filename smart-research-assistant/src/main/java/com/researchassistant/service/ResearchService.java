package com.researchassistant.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.researchassistant.dto.ResearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResearchService {

    private final Client geminiClient;

    @Value("${gemini.model.name:gemini-2.5-flash}")
    private String modelName;

    public String fetchAIResponse(ResearchRequest request) {
        log.info("Processing research request. Operation: {}", request.operation());

        try {

            String finalPrompt = request.operation().buildPrompt(request.content());

            GenerateContentResponse response = geminiClient.models.generateContent(
                    modelName,
                    finalPrompt,
                    null
            );


            if (response == null || response.text() == null) {
                log.warn("Received empty response from AI model");
                return "No response generated.";
            }

            return response.text();

        } catch (Exception e) {
            log.error("Error communicating with AI Client: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process research request", e);
        }
    }
}