package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.payload.request.LoginRequest;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.List;

public interface IUserService {

    List<User> getUsers();
    User getUserById(Long id);
    ResponseEntity<MessageResponse> addRoleToUser(@Valid LoginRequest loginRequest);
    ResponseEntity<MessageResponse> addTrackToUser(@Valid UserRequest userRequest);


}
