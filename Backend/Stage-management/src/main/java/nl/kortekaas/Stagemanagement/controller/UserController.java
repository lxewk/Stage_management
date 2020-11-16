package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/stagemanager")
    public String stagemanagerAccess() { return userService.generateStagemanagerContent(); }

    @GetMapping(value = "/deputy")
    public String deputyAccess() { return userService.generateDeputyContent(); }

    @GetMapping(value = "/assistant")
    public String assistantAccess() { return userService.generateAssContent(); }

    @GetMapping(value = "/crew")
    public String crewAccess() { return userService.generateCrewContent();  }

    @GetMapping(value = "/props")
    public String propsAccess() { return userService.generatePropsContent();  }

    @GetMapping(value = "/creative")
    public String creativeAccess() { return userService.generateCreativeContent();  }

    @GetMapping(value = "/production")
    public String productionAccess() { return userService.generateProductionContent();  }

    @GetMapping
    public List<User> AllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/new")
    public void registerNewUser(@RequestBody User newUser, ERole newRole) {  userService.registerUser(newUser, newRole); }

    @PostMapping(value = "/track")
    public ResponseEntity<MessageResponse> addNewTrackToUser(@RequestBody UserRequest userRequest)
    { return userService.addTrackToUser(userRequest); }

}
