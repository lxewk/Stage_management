package nl.kortekaas.Stagemanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tracks")
    private User track_user;

    @OneToOne(mappedBy = "hasRisk")
    private Risk hasTrack;

    public Track() {}

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
