package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Enumerated(EnumType.STRING)
    private ERole role;

    private String nameNewUser;
    private String password;

    public Account() {}

    public Account(ERole role, String nameNewUser) {
        this.role = role;
        this.nameNewUser = nameNewUser;
        this.password = password;
    }

    public void createPassword(String nameNewUser, ERole roleInApp) {
        System.out.println(password);
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getNameNewUser() { return nameNewUser; }

    public void setNameNewUser(String nameNewUser) { this.nameNewUser = nameNewUser;}

    public ERole getRole() { return role; }

    public void setRole(ERole roleInApp) { this.role = roleInApp; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
