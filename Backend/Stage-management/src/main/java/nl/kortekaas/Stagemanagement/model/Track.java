package nl.kortekaas.Stagemanagement.model;

import nl.kortekaas.Stagemanagement.model.enums.ETrack;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name = "tracks", schema = "public")
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
    @Column(columnDefinition = "serial", name = "track_id")
    private long id;

    private String crewName;

    @Enumerated(EnumType.STRING)
    private ETrack position;


    public Track() {}

    public Track(String crewName, ETrack position) {
        this.crewName = crewName;
        this.position = position;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public ETrack getPosition() {
        return position;
    }

    public void setPosition(ETrack name) {
        this.position = name;
    }
}
