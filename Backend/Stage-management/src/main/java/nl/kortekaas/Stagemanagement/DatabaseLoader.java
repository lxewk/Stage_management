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

        List<Role> roles = new ArrayList<>();

        User stagemanager = new User();
        stagemanager.setUsername("Nick Stuivenberg");
        stagemanager.setPassword("smBoogieWoogie");
        Role role = new Role(ERole.STAGEMANAGER);
        roles.add(role);
        stagemanager.setRoles(roles);
        userService.registerUser(stagemanager);

        User deputy = new User();
        deputy.setUsername("Lisette Tates");
        deputy.setPassword("dsmBoogieWoogie");
        role.setName(ERole.DEPUTY);
        deputy.setRoles(roles);
        userService.saveUser(deputy);
        userService.registerUser(deputy);

        User assistant = new User();
        assistant.setUsername("Jos Vervelde ");
        assistant.setPassword("asmBoogieWoogie");
        role.setName(ERole.ASSISTANT);
        assistant.setRoles(roles);
        userService.saveUser(assistant);
        userService.registerUser(assistant);

        User crew = new User();
        crew.setUsername("Elles Kortekaas");
        crew.setPassword("crewBoogieWoogie");
        role.setName(ERole.CREW);
        crew.setRoles(roles);
        userService.saveUser(crew);
        userService.registerUser(crew);

        User props = new User();
        props.setUsername("Peter v/d Helm");
        props.setPassword("propsBoogieWoogie");
        role.setName(ERole.PROPS);
        props.setRoles(roles);
        userService.saveUser(props);
        userService.registerUser(props);

        User creative = new User();
        creative.setUsername("Carla");
        creative.setPassword("creativeBoogieWoogie");
        role.setName(ERole.CREATIVE);
        creative.setRoles(roles);
        userService.saveUser(creative);
        userService.registerUser(creative);

        User production = new User();
        production.setUsername("Anneloes Welter");
        production.setPassword("prodBoogieWoogie");
        role.setName(ERole.PRODUCTION);
        production.setRoles(roles);
        userService.saveUser(production);
        userService.registerUser(production);
    }
}
