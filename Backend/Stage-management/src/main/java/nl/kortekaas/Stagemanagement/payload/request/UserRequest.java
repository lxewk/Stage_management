package nl.kortekaas.Stagemanagement.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private Set<String> trackName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getTrackName() {
        return trackName;
    }

    public void setTrackName(Set<String> trackName) {
        this.trackName = trackName;
    }
}
