package nl.kortekaas.Stagemanagement;

import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import nl.kortekaas.Stagemanagement.service.ItemService;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.IOException;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AuthorizationService authorizationService;
    private final UserService userService;
    private ItemService itemService;



    @Autowired
    public DatabaseLoader(AuthorizationService authorizationService, UserService userService, ItemService itemService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) throws IOException {

        User stagemanager = new User();
        stagemanager.setUsername("nStuivenberg");
        stagemanager.setPassword("smbw");
        userService.registerUser(stagemanager, ERole.STAGEMANAGER);

        User deputy = new User();
        deputy.setUsername("lTates");
        deputy.setPassword("dsmbw");
        userService.registerUser(deputy, ERole.DEPUTY);

        User assistant = new User();
        assistant.setUsername("jVervelde");
        assistant.setPassword("asmbw");
        userService.registerUser(assistant, ERole.ASSISTANT);

        User crew = new User();
        crew.setUsername("eKortekaas");
        crew.setPassword("crewbw");
        userService.registerUser(crew, ERole.CREW);

        User props = new User();
        props.setUsername("pvdHelm");
        props.setPassword("propsbw");
        userService.registerUser(props, ERole.PROPS);

        User creative = new User();
        creative.setUsername("cToren");
        creative.setPassword("creabw");
        userService.registerUser(creative, ERole.CREATIVE);

        User production = new User();
        production.setUsername("aWelter");
        production.setPassword("prodbw");
        userService.registerUser(production, ERole.PRODUCTION);


    }
}
