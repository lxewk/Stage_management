package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long accountId;

    private Role role;
    private User newUser;
    private String nameNewUser;
    private String password;
    private String newPassword;

    @OneToOne(mappedBy = "user_account")
    private User user;

    @ManyToMany(mappedBy = "account")
    private Set<Role> roles = new HashSet<>();

    public Account() {}

    public Account(Role role, String nameNewUser) {
        this.role = role;
        this.newUser = newUser;
        this.nameNewUser = nameNewUser;
        this.password = getNewPassword();
        this.newPassword = newPassword;
    }

    public String createPassword(String nameNewUser) {
        return newPassword;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getNameNewUser() { return nameNewUser; }

    public void setNameNewUser(String nameNewUser) { this.nameNewUser = nameNewUser;}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String password) {
        this.newPassword = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
