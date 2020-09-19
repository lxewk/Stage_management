package nl.kortekaas.Stagemanagement;

import nl.kortekaas.Stagemanagement.model.Show;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import nl.kortekaas.Stagemanagement.service.ItemService;
import nl.kortekaas.Stagemanagement.service.ShowService;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.IOException;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AuthorizationService authorizationService;
    private final UserService userService;
    private ShowService showService;



    @Autowired
    public DatabaseLoader(AuthorizationService authorizationService, UserService userService, ShowService showService ) {
        this.authorizationService = authorizationService;
        this.userService = userService;
        this.showService = showService;
    }

    @Override
    public void run(String... args) throws IOException {

        User stagemanager = new User();
        stagemanager.setUsername("jSuiker");
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

        Show showProduction1 = new Show();
        showProduction1.setName("The Bodyguard");
        showProduction1.setPosterArt("./assets/TheBodyGuard.svg");
        showProduction1.setStagemanager("Nanko Flutte");
        showService.saveShow(showProduction1);

        Show showProduction2 = new Show();
        showProduction2.setName("Jersey Boys");
        showProduction2.setPosterArt("./assets/JerseyBoys.svg");
        showProduction2.setStagemanager("Jan Suiker");
        showService.saveShow(showProduction2);

    }
}
