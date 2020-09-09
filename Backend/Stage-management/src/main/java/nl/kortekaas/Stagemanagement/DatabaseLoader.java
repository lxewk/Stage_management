package nl.kortekaas.Stagemanagement;

import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.payload.request.LoginRequest;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AuthorizationService authorizationService;
    private final UserService userService;

    @Autowired
    public DatabaseLoader(AuthorizationService authorizationService, UserService userService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        /*
        STAGEMANAGER,
                DEPUTY,
                ASSISTANT,
                CREW,
                PROPS,
                CREATIVE,
                PRODUCTION
                */


        User user = new User();
        user.setUsername("nstuivenberg");
        user.setPassword("sjaak");

        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName(ERole.STAGEMANAGER);
        roles.add(role);

        user.setRoles(roles);

        // opslaan

        userService.registerUser(user);

        //gebruiker 2
        User deputy = new User();
        deputy.setUsername("deputyUser");
        deputy.setPassword("Henk");
        roles.get(0).setName(ERole.DEPUTY);
        deputy.setRoles(roles);
        userService.registerUser(deputy);





//        List<String> rollen = new ArrayList<>();
//        rollen.add("stagemanager");
//
//        LoginRequest stage = new LoginRequest();
//        stage.setUsername("Nick Stuivenberg");
//        stage.setPassword("smBoogieWoogie");
//        stage.setRoles(rollen);
//        userService.addRoleToUser(stage);
//        authorizationService.authenticateUser(stage);
//
//
//        LoginRequest deputy = new LoginRequest();
//        deputy.setUsername("Lisette Tates");
//        deputy.setPassword("dsmBoogieWoogie");
//        rollen.remove("stagemanager");
//        rollen.add("deputy");
//        userService.addRoleToUser(deputy);
//        authorizationService.authenticateUser(deputy);

    }
}
