package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.payload.request.LoginRequest;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.List;

public interface IUserService {

    String dashboard();
    List<User> getAllUsers();
    ResponseEntity<MessageResponse> addRoleToUser(@Valid UserRequest userRequest);
    ResponseEntity<MessageResponse> addTrackToUser(@Valid UserRequest userRequest);
    void registerUser(User user, ERole role);
}
