package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


@Entity
@Table(name = "APP_USER")
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
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account user_account;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item_user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user_track",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "USER_NOTE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "NOTE_ID"))
    private Set<Note> Notes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "USER_TODO",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TODO_ID"))
    private Set<Todo> Todos = new HashSet<>();


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
