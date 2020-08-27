package nl.kortekaas.Stagemanagement.domain;

public class Role {

    private long id;
    private String name;
    private String password;
    private boolean loggedIn;
    private int receivedNote;

    public Role(long id, String name){
        this.id = id;
        this.name = name;
        this.password = password;
        this.loggedIn = false;
        this.receivedNote = 0;
    }

    public long getId(){ return id; }

    public void setId(long id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }
    
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public int getReceivedNote(){ return receivedNote; }

    public void setReceivedNote(int receivedNote) { this.receivedNote++;}


}
