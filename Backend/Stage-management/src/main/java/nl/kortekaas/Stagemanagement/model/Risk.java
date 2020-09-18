package nl.kortekaas.Stagemanagement.model;

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
    @Column(columnDefinition = "serial", name = "RISK_ID")
    private long id;

    private String possibleRisks;
    private Item item;
    private Track track;


    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    public Item getItem() {
        return item;
    }

    @ManyToOne
    @JoinColumn(name = "TRACK_ID")
    public Track getTrack() {
        return track;
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPossibleRisks() { return possibleRisks; }

    public void setPossibleRisks(String possibleRisks) { this.possibleRisks = possibleRisks; }

    public void setItem(Item item) { this.item = item; }

    public void setTrack(Track track) { this.track = track; }

}
