package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.payload.request.LoginRequest;
import nl.kortekaas.Stagemanagement.payload.response.JwtResponse;
import nl.kortekaas.Stagemanagement.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }
}
