package nl.kortekaas.Stagemanagement;

import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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


        User stagemanager = new User();
        stagemanager.setUsername("Nick Stuivenberg");
        stagemanager.setPassword("smBoogieWoogie");
        userService.registerUser(stagemanager, ERole.STAGEMANAGER);

        /*
        User deputy = new User();
        deputy.setUsername("Lisette Tates");
        deputy.setPassword("dsmBoogieWoogie");
        role.setName(ERole.DEPUTY);
        deputy.setRoles(roles);
        userService.registerUser(deputy);

        User assistant = new User();
        assistant.setUsername("Jos Vervelde ");
        assistant.setPassword("asmBoogieWoogie");
        role.setName(ERole.ASSISTANT);
        assistant.setRoles(roles);
        userService.registerUser(assistant);

        User crew = new User();
        crew.setUsername("Elles Kortekaas");
        crew.setPassword("crewBoogieWoogie");
        role.setName(ERole.CREW);
        crew.setRoles(roles);
        userService.registerUser(crew);

        User props = new User();
        props.setUsername("Peter v/d Helm");
        props.setPassword("propsBoogieWoogie");
        role.setName(ERole.PROPS);
        props.setRoles(roles);
        userService.registerUser(props);

        User creative = new User();
        creative.setUsername("Carla");
        creative.setPassword("creativeBoogieWoogie");
        role.setName(ERole.CREATIVE);
        creative.setRoles(roles);
        userService.registerUser(creative);

        User production = new User();
        production.setUsername("Anneloes Welter");
        production.setPassword("prodBoogieWoogie");
        role.setName(ERole.PRODUCTION);
        production.setRoles(roles);
        userService.registerUser(production);
        */

    }
}
