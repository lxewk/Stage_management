package nl.kortekaas.Stagemanagement.model;

import nl.kortekaas.Stagemanagement.model.enums.ETask;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Track {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial", name = "TRACK_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    private ETask task;

    private Set<Risk> risks;
    private Set<User> users = new HashSet<>();


    @ManyToMany(mappedBy = "tracks")
    public Set<User> getUsers() {
        return users;
    }

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    public Set<Risk> getRisks() {
        return risks;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public void setRisks(Set<Risk> risks) { this.risks = risks; }

    public void setUsers(Set<User> users) { this.users = users; }

    public ETask getTask() {
        return task;
    }

    public void setTask(ETask task) {
        this.task = task;
    }

}
