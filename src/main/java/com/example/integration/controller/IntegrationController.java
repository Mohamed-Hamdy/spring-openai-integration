package com.example.integration.controller;

import org.springframework.web.bind.annotation.*;

import com.example.integration.Services.IntegrationService;
import com.example.integration.entities.Integration;

import java.util.List;

@RestController
@RequestMapping("api/v1/integrate")
public class IntegrationController {

    private final IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping
    public List<Integration> getEngineers() {
        return integrationService.getAllIntegrations();
    }

    @GetMapping("{id}")
    public Integration getEngineerById(
            @PathVariable Integer id
    ) {
        return integrationService.getIntegrationById(id);
    }


    @PostMapping
    public void addNewIntegration(
            @RequestBody Integration integration
    ) {
        integrationService.insertIntegration(integration);
    }

    @DeleteMapping("{id}")
    public void deleteIntegration(@PathVariable Integer id) {
        integrationService.deleteIntegration(id);
    }

    @PutMapping("{id}")
    public void updateIntegration(@PathVariable Integer id,
                                       @RequestBody Integration integration) {
        integrationService.updateIntegration(id, integration);
    }
}
