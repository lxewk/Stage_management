package nl.kortekaas.Stagemanagement.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @PreAuthorize("hasRole('STAGEMANAGER')")
    public String generateStagemanagerContent() { return "Stagemanager Content."; }

    @PreAuthorize("hasRole('DEPUTY')")
    public String generateDeputyContent() { return "Deputy Content."; }

    @PreAuthorize("hasRole('ASSISTANT')")
    public String generateAssContent() { return "Assistant Board."; }

    @PreAuthorize("hasRole('CREW')")
    public String generateCrewContent() { return "Crew Board."; }

    @PreAuthorize("hasRole('PROPS')")
    public String generatePropsContent() { return "Props Board."; }

    @PreAuthorize("hasRole('CREATIVE')")
    public String generateCreativeContent() { return "Creative Board."; }

    @PreAuthorize("hasRole('PRODUCTION')")
    public String generateProductionContent() { return "Production Board."; }

    public String generateDashboardContent() { return " Dashboard."; }
}
