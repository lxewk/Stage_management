package nl.kortekaas.Stagemanagement.payload.request;

import java.util.Set;

public class AccountRequest {

    private String username;
    private Set<String> roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(Set<String> roleName) {
        this.roleName = roleName;
    }
}
