package nl.kortekaas.Stagemanagement.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private Set<String> roles;

    @NotBlank
    private List<String> tracks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getTrackName() {
        return tracks;
    }

    public void setTrackName(List<String> trackName) {
        this.tracks = tracks;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
