package nl.kortekaas.Stagemanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(columnDefinition = "serial")
    private long trackId;

    @Enumerated(EnumType.STRING)
    private ETask task;

    private String trackName;

    @ManyToMany(mappedBy = "tracks")
    private Set<User> users = new HashSet<>();

    @OneToOne(mappedBy = "hasRisk")
    private Risk hasTrack;

    public Track() {}

    public Track(ETask task) {
        this.task = task;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
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
