package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class User {

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
    private long userId;

    private String name;
    private Account account;
    private boolean loggedIn;
    private int receivedNote;

    public User() {}

    public User(String name, Account account){
        this.name = name;
        this.account = new Account();
        this.loggedIn = false;
        this.receivedNote = 0;

    }

    public long getId(){ return userId; }

    public void setId(long id) { this.userId = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public int getReceivedNote(){ return receivedNote; }

    public void setReceivedNote(int receivedNote) { this.receivedNote++;}


}
