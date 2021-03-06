package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.model.Track;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.model.enums.ETrack;
import nl.kortekaas.Stagemanagement.payload.request.UserRequest;
import nl.kortekaas.Stagemanagement.payload.response.MessageResponse;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.*;

@Service
@Validated
public class UserService implements IUserService {

    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";
    private static final String TRACK_NOT_FOUND_ERROR = "Error: Track not found.";

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;
    private TrackRepository trackRepository;

    @Autowired
    public void setEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) { this.roleRepository = roleRepository; }

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }


    @Secured("ROLE_STAGEMANAGER")
    public String generateStagemanagerContent() { return "Stagemanager Board"; }

    @Secured("ROLE_DEPUTY")
    public String generateDeputyContent() { return "Deputy Board"; }

    @PreAuthorize("hasRole('ROLE_ASSISTANT')")
    public String generateAssContent() { return "Assistant Board"; }

    @PreAuthorize("hasRole('ROLE_CREW')")
    public String generateCrewContent() {return "Crew Board"; }

    @PreAuthorize("hasRole('ROLE_PROPS')")
    public String generatePropsContent() { return "Props Board."; }

    @PreAuthorize("hasRole('ROLE_CREATIVE')")
    public String generateCreativeContent() { return "Creative Board."; }

    @PreAuthorize("hasRole('ROLE_PRODUCTION')")
    public String generateProductionContent() { return "Production Board."; }


    @Secured({"ROLE_STAGEMANAGER", "ROLE_DEPUTY"})
    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }



    public void registerUser(User user, ERole roleName) {
        if (Boolean.TRUE.equals(userRepository.existsByUsername(user.getUsername()))) {

            throw new RuntimeException("This username is already taken: " + user.getUsername());
        }

        if (user.getPassword() == null) {
            throw new RuntimeException("No password");
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ROLE_STAGEMANAGER')")
    @Override
    public ResponseEntity<MessageResponse> addTrackToUser(@Valid UserRequest userRequest) {

        User user = new User();
        user.setUsername(userRequest.getUsername());

        Set<String> strTracks = userRequest.getTracks();
        Set<Track> tracks = new HashSet<>();

        strTracks.forEach(task -> {
            switch (task) {
                case "asm_sl":
                    Track asm_slTrack = trackRepository.findByPosition(ETrack.ASM_SL)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(asm_slTrack);

                    break;
                case "asm_sr":
                    Track asm_srTrack = trackRepository.findByPosition(ETrack.ASM_SR)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(asm_srTrack);

                    break;
                case "sl_1":
                    Track sl_1Track = trackRepository.findByPosition(ETrack.SL_1)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sl_1Track);

                    break;
                case "sl_2":
                    Track sl_2Track = trackRepository.findByPosition(ETrack.SL_2)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sl_2Track);

                    break;
                case "sl_3":
                    Track sl_3Track = trackRepository.findByPosition(ETrack.SL_3)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sl_3Track);

                    break;
                case "sr_1":
                    Track sr_1Track = trackRepository.findByPosition(ETrack.SR_1)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sr_1Track);

                    break;
                case "sr_2":
                    Track sr_2Track = trackRepository.findByPosition(ETrack.SR_2)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sr_2Track);

                    break;
                case "sr_3":
                    Track sr_3Track = trackRepository.findByPosition(ETrack.SR_3)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(sr_3Track);

                    break;
                case "swing":
                    Track swingTrack = trackRepository.findByPosition(ETrack.SWING)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(swingTrack);

                    break;
                case "auto_operator":
                    Track auto_operatorTrack = trackRepository.findByPosition(ETrack.AUTO_OPERATOR)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(auto_operatorTrack);

                    break;
                case "auto_trouble":
                    Track auto_troubleTrack = trackRepository.findByPosition(ETrack.AUTO_TROUBLE)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(auto_troubleTrack);

                    break;
                case "lx_trouble":
                    Track lx_troubleTrack = trackRepository.findByPosition(ETrack.LX_TROUBLE)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(lx_troubleTrack);

                    break;
                case "snd_trouble":
                    Track snd_troubleTrack = trackRepository.findByPosition(ETrack.SND_TROUBLE)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(snd_troubleTrack);

                    break;
                case "video_trouble":
                    Track video_troubleTrack = trackRepository.findByPosition(ETrack.VIDEO_TROUBLE)
                            .orElseThrow(() -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
                    tracks.add(video_troubleTrack);

            }
        });

        user.setTracks(tracks);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("The track is added to crewmember " + userRequest.getUsername() ));

    }
}
