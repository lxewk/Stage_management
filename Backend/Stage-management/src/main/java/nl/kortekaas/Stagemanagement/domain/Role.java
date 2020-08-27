package nl.kortekaas.Stagemanagement.domain;

public class Role {

    private long roleId;
    private String name;
    private String password;
    private boolean loggedIn;
    private int receivedNote;

    public Role(long roleId, String name){
        this.roleId = roleId;
        this.name = name;
        this.password = password;
        this.loggedIn = false;
        this.receivedNote = 0;
    }

    public long getId(){ return roleId; }

    public void setId(long id) { this.roleId = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }
    
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public int getReceivedNote(){ return receivedNote; }

    public void setReceivedNote(int receivedNote) { this.receivedNote++;}


}
