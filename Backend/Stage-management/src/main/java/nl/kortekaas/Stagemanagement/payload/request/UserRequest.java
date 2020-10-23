package nl.kortekaas.Stagemanagement.payload.request;

import java.util.Set;

public class UserRequest {

    private String username;
    private Set<String> tracks;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getTracks() {
        return tracks;
    }

    public void setTracks(Set<String> tracks) {
        this.tracks = tracks;
    }

}
