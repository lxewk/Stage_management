package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.List;

public interface IUserService {

    List<User> getUsers();
    ResponseEntity<MessageResponse> addRoleToUser(@Valid UserRequest userRequest);
    ResponseEntity<MessageResponse> addTrackToUser(@Valid UserRequest userRequest);


}
