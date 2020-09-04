package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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

    private String nameNewUser;
    private String newPassword;

    @OneToOne(mappedBy = "user_account")
    private User accountUser;

    @ManyToMany(mappedBy = "account")
    private Set<Role> roles = new HashSet<>();

    public Account() {}

    public Account(String nameNewUser) {
        this.nameNewUser = nameNewUser;
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


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String password) {
        this.newPassword = password;
    }

    public User getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(User user) {
        this.accountUser = user;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
