package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
public class Risk {

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
    private long riskId;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Track track;

    public Risk() {}

    public long getId() {
        return riskId;
    }

    public void setId(long riskId) {
        this.riskId = riskId;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
