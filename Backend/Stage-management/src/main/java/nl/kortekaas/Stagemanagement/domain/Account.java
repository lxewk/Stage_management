package nl.kortekaas.Stagemanagement.domain;

public class Account {

    private String nameNewUser;
    private RolesInApp roleInApp;
    private Role role;

    public Account(Role role) {
        this.role = role;
        this.nameNewUser = nameNewUser;
        this.roleInApp = roleInApp;
    }

    public void createPassword(String nameNewUser, RolesInApp roleInApp) {
        Account newUser = new Account(this.role);

    }

    public String getNameNewUser() { return nameNewUser; }

    public void setNameNewUser(String nameNewUser) { this.nameNewUser = nameNewUser;}

    public RolesInApp getRoleInApp() { return roleInApp; }

    public void setRoleInApp(RolesInApp roleInApp) { this.roleInApp = roleInApp; }
}
