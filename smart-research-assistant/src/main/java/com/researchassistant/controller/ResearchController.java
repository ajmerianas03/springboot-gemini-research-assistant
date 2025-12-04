package com.researchassistant.controller;

import com.researchassistant.dto.ResearchRequest;
import com.researchassistant.service.ResearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class ResearchController {

    private final ResearchService researchService;

    @PostMapping("/process")
    public ResponseEntity<String> processResearchRequest(@RequestBody ResearchRequest request) {
        log.info("Received research request. Operation: {}", request.operation());


        if (request.content() == null || request.content().isBlank()) {
            return ResponseEntity.badRequest().body("Request content cannot be empty");
        }

        String result = researchService.fetchAIResponse(request);

        return ResponseEntity.ok(result);
    }
}