package nl.kortekaas.Stagemanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties(value = "roles")
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
    @Column(columnDefinition = "serial", name = "USER_ID")
    private long id;

    private String username;
    private String password;

    private Set<Role> roles;
    private Set<Todo> todos;
    private Set<Track> tracks = new HashSet<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Todo> getTodos() {
        return todos;
    }

    @ManyToMany
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    public Set<Role> getRoles() {
        return roles;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_TRACK",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRACK_ID"))
    public Set<Track> getTracks() {
        return tracks;
    }


    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void setRoles(Set<Role> roles) { this.roles = roles; }

    public void setTodos(Set<Todo> todos) { this.todos = todos; }

    public void setTracks(Set<Track> tracks) { this.tracks = tracks; }

}
