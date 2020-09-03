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
    private String password;
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
        this.password = password;
        this.loggedIn = false;
        this.receivedNote = 0;

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Set<Note> getNotes() {
        return Notes;
    }

    public void setNotes(Set<Note> notes) {
        Notes = notes;
    }

    public Set<Todo> getTodos() {
        return Todos;
    }

    public void setTodos(Set<Todo> todos) {
        Todos = todos;
    }

    public boolean getLoggedIn() { return loggedIn; }

    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public int getReceivedNote(){ return receivedNote; }

    public void setReceivedNote(int receivedNote) { this.receivedNote++;}

    public Account getUser_account() { return user_account; }

    public void setUser_account(Account user_account) { this.user_account = user_account; }

}
