package com.example.integration.Services;

import com.example.integration.entities.Integration;
import com.example.integration.Repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {

    private final Repository repository;
    private final ChatService chatService;

    public IntegrationService(Repository repository, ChatService chatService) {
        this.repository = repository;
        this.chatService = chatService;
    }

    /**
     * Fetch all integrations.
     */
    public List<Integration> getAllIntegrations() {
        return repository.findAll();
    }

    /**
     * Insert a new integration and generate a learning path.
     */
    public void insertIntegration(Integration integration) {
        String prompt = String.format(
            """
            Based on the programming tech stack %s that %s has given,
            provide a full learning path and recommendations for this person.
            """,
            integration.getTechStack(),
            integration.getName()
        );

        String chatResponse = chatService.getChatResponse(prompt);
        integration.setLearningPathRecommendation(chatResponse);
        repository.save(integration);
    }

    /**
     * Get a single integration by its ID.
     */
    public Integration getIntegrationById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Integration with ID " + id + " not found"));
    }

    /**
     * Delete an integration by its ID.
     */
    public void deleteIntegration(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalStateException("Integration with ID " + id + " not found");
        }
        repository.deleteById(id);
    }

    /**
     * Update the name and tech stack of an existing integration.
     */
    public void updateIntegration(Integer id, Integration update) {
        Integration existingIntegration = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Integration with ID " + id + " not found"));

        existingIntegration.setName(update.getName());
        existingIntegration.setTechStack(update.getTechStack());
        repository.save(existingIntegration);
    }
}
