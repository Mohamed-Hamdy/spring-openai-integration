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
            A person named %s wants to become proficient in the following tech stack: %s.
            
            Please generate a structured and comprehensive learning path that includes:
            - Core concepts to master
            - Recommended tools and frameworks
            - Free or paid learning resources (like courses or books)
            - Real-world project ideas to practice
            - Estimated learning duration or progression roadmap
            - Any additional tips or best practices

            Format the response with headings, bullet points, and clarity for easy understanding.
            """,
            integration.getName(),
            integration.getTechStack()
        );

        String chatResponse = chatService.getChatResponse(prompt);
        integration.setTechStackRecommended(chatResponse);
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
