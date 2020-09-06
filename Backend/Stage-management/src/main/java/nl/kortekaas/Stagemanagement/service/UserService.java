package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class UserService implements IUserService {

    private static final String TRACK_NOT_FOUND_ERROR = "Error: Track is not found.";

    private UserRepository userRepository;
    private TodoRepository todoRepository;
    private ItemRepository itemRepository;
    private NoteRepository noteRepository;
    private TrackRepository trackRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) { this.todoRepository = todoRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) { this.noteRepository = noteRepository; }

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }


    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('DEPUTY')")
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }


    @PreAuthorize("hasRole('STAGEMANAGER')")
    public ResponseEntity<MessageResponse> addTrackToUser(@Valid UserRequest userRequest) {

        User userTrack = new User(userRequest.getUsername(),
                userRequest.getTrackName());
//
//        Set<String> strRoles = accountRequest.getRoleName();
//        Set<Role> roles = new HashSet<>();
//
//        strRoles.forEach(role -> {
//            switch (role) {
//                case "stagemanager":
//                    Role stagemanagerRole = roleRepository.findByName(ERole.STAGEMANAGER)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(stagemanagerRole);
//
//                    break;
//                case "deputy":
//                    Role deputyRole = roleRepository.findByName(ERole.DEPUTY)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(deputyRole);
//
//                    break;
//                case "assistant":
//                    Role assistantRole = roleRepository.findByName(ERole.ASSISTANT)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(assistantRole);
//
//                    break;
//                case "crew":
//                    Role crewRole = roleRepository.findByName(ERole.CREW)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(crewRole);
//
//                    break;
//                case "props":
//                    Role propsRole = roleRepository.findByName(ERole.PROPS)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(propsRole);
//
//                    break;
//                case "creative":
//                    Role creativeRole = roleRepository.findByName(ERole.CREATIVE)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(creativeRole);
//
//                    break;
//                case "production":
//                    Role productionRole = roleRepository.findByName(ERole.PRODUCTION)
//                            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
//                    roles.add(productionRole);
//            }
//        });

        userTrack.getTracks();
        userRepository.save(userTrack);

        return ResponseEntity.ok(new MessageResponse("Add track to crew"));

    }

    @Override
    public User addUserToAccount() {
        return null; //TODO, staat misschien al in account
    }

}
