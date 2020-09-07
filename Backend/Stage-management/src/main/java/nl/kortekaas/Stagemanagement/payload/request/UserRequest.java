package nl.kortekaas.Stagemanagement.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;


public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private List<String> roles;

    @NotBlank
    private List<String> tracks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTrackName() {
        return tracks;
    }

    public void setTrackName(List<String> trackName) {
        this.tracks = tracks;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
