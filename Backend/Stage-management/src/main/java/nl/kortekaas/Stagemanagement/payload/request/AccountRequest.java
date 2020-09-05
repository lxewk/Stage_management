package nl.kortekaas.Stagemanagement.payload.request;

import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class AccountRequest {

    @NotBlank
    private String username;

    @NotBlank
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
