package com.researchassistant.dto;

import com.researchassistant.enums.ResearchOperation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResearchRequest(
        @NotBlank(message = "Content cannot be empty")
        String content,

        @NotNull(message = "Operation is required")
        ResearchOperation operation
) {}