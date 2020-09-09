package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/stagemanager")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<MessageResponse> makeUserTrack(@RequestBody UserRequest userRequest) {
        return userService.addTrackToUser(userRequest);
    }
}
