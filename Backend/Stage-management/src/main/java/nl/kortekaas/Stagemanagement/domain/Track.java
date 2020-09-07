package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


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
    @Column(columnDefinition = "serial")
    private long trackId;

    @Enumerated(EnumType.STRING)
    private ETask task;

    private String trackName;

    @ManyToMany(mappedBy = "tracks")
    private List<User> users;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "track")
    private List<Risk> risk;

    public Track() {}

    public Track(ETask task) { this.task = task; }

    public long getId() {
        return trackId;
    }

    public void setId(long trackId) {
        this.trackId = trackId;
    }

    public ETask getTask() {
        return task;
    }

    public void setTask(ETask task) {
        this.task = task;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Risk> getRisk() {
        return risk;
    }

    public void setRisk(List<Risk> risk) {
        this.risk = risk;
    }
}
