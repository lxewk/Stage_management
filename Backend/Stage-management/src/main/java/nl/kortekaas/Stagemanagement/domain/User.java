package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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

    private String username;
    private String password;
    private boolean loggedIn;
    private int receivedNote;

    @ManyToMany
    @JoinTable (name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<Role> roles;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "creator",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "USER_TRACK",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRACK_ID"))
    private List<Track> tracks;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sender")
    private List<Note> sentNotes;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receiver")
//    private List<Note> receivedNotes;

    @ManyToMany
    @JoinTable(
            name = "USER_TODO",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TODO_ID"))
    private List<Todo> todo_s;


    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, List<Track> tracks) {
        this.username = username;
        this.tracks = tracks;
    }

    public long getId() {
        return userId;
    }

    public void setId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<Note> getSentNotes() {
        return sentNotes;
    }

    public void setSentNotes(List<Note> sentNotes) {
        this.sentNotes = sentNotes;
    }

    public int getReceivedNote() {
        return receivedNote;
    }

    public void setReceivedNote(int receivedNote) {
        this.receivedNote = receivedNote;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Todo> getTodo_s() {
        return todo_s;
    }

    public void setTodo_s(List<Todo> todo_s) {
        this.todo_s = todo_s;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

//    public List<Note> getReceivedNotes() {
//        return receivedNotes;
//    }
//
//    public void setReceivedNotes(List<Note> receivedNotes) {
//        this.receivedNotes = receivedNotes;
//    }
}
