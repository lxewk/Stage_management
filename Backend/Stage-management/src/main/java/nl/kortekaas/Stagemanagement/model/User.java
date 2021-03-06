package nl.kortekaas.Stagemanagement.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
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
    @Column(columnDefinition = "serial", name = "user_id")
    private long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set <Role> roles;

    @ManyToMany
    @JoinTable (name = "user_track",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set <Track> tracks;

    private String username;
    private String password;
    private int todo;
    private int note;


    public User() {}

    public User(String username) {
        this.username = username;
        this.password = "";
        this.todo = 0;
        this.note = 0;
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

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

    public int getTodo() { return todo; }

    public void setTodo(int todo) { this.todo = todo; }

    public int getNote() { return note; }

    public void setNote(int note) { this.note = note; }

    public Set<Track> getTracks() { return tracks; }

    public void setTracks(Set<Track> tracks) { this.tracks = tracks; }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}


