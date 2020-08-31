package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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
    private boolean loggedIn;
    private int receivedNote;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_Id", referencedColumnName = "accountId")
    private Account account;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item_user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "track_user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Track> tracks;

    @ManyToMany
    @JoinTable(
            name = "user_note",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id"))
    Set<Note> sendNotes;

    @ManyToMany
    @JoinTable(
            name = "user_todo",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id"))
    Set<Todo> doesTodo;


    public User() {}

    public User(String name){
        this.name = name;
        this.loggedIn = false;
        this.receivedNote = 0;

    }

    public long getId(){ return userId; }

    public void setId(long id) { this.userId = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public int getReceivedNote(){ return receivedNote; }

    public void setReceivedNote(int receivedNote) { this.receivedNote++;}


}
