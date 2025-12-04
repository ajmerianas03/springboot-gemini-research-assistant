package com.researchassistant.enums;

import lombok.Getter;

@Getter
public enum ResearchOperation {
    SUMMARIZE("Provide a clear and concise summary of the following text in a few sentences:\n\n"),
    SUGGEST("Based on the following content: suggest related topics and further reading. Format the response with clear headings and bullet points:\n\n");

    private final String promptTemplate;

    ResearchOperation(String promptTemplate) {
        this.promptTemplate = promptTemplate;
    }

    public String buildPrompt(String content) {
        return this.promptTemplate + content;
    }
}