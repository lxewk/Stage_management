package nl.kortekaas.Stagemanagement;

import nl.kortekaas.Stagemanagement.model.Item;
import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import nl.kortekaas.Stagemanagement.service.ItemService;
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
    private ItemService itemService;



    @Autowired
    public DatabaseLoader(AuthorizationService authorizationService, UserService userService, ItemService itemService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) {


        User stagemanager = new User();
        stagemanager.setUsername("nStuivenberg");
        stagemanager.setPassword("smBoogieWoogie");
        userService.registerUser(stagemanager, ERole.STAGEMANAGER);

        User deputy = new User();
        deputy.setUsername("lTates");
        deputy.setPassword("dsmBoogieWoogie");
        userService.registerUser(deputy, ERole.DEPUTY);

        User assistant = new User();
        assistant.setUsername("jVervelde");
        assistant.setPassword("asmBoogieWoogie");
        userService.registerUser(assistant, ERole.ASSISTANT);

        User crew = new User();
        crew.setUsername("eKortekaas");
        crew.setPassword("crewBoogieWoogie");
        userService.registerUser(crew, ERole.CREW);

        User props = new User();
        props.setUsername("pvdHelm");
        props.setPassword("propsBoogieWoogie");
        userService.registerUser(props, ERole.PROPS);

        User creative = new User();
        creative.setUsername("cToren");
        creative.setPassword("creaBoogieWoogie");
        userService.registerUser(creative, ERole.CREATIVE);

        User production = new User();
        production.setUsername("aWelter");
        production.setPassword("prodBoogieWoogie");
        userService.registerUser(production, ERole.PRODUCTION);

        Item stalkerDesk = new Item();
        stalkerDesk.setItemName("Stalker desk");
        itemService.addItemToUserByUsername("pvdHelm", stalkerDesk);
        itemService.saveItem(stalkerDesk);

    }
}
