package nl.kortekaas.Stagemanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = { "users" })
public class Role {

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
    private long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {}

    public Role(ERole harry) {
        this.name = harry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public Set<User> getUsers() {
       return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
