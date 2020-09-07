package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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



}
