package nl.kortekaas.Stagemanagement;


import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.payload.request.LoginRequest;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseLoader(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        LoginRequest deputy = new LoginRequest();
        deputy.setUsername("Lisette Tates");
        deputy.setPassword("dsmBoogieWoogie");
        authorizationService.authenticateUser(deputy);

        LoginRequest stagemanager = new LoginRequest();
        stagemanager.setUsername("Nick Stuivenberg");
        stagemanager.setPassword("smBoogieWoogie");
        authorizationService.authenticateUser(stagemanager);

    }


}
