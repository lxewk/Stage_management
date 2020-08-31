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

    private String itemName;
    private String trackName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "track_id", referencedColumnName = "trackId")
    private Track hasRisk;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    private Item hasOneRisk;

    public Risk(){
        this.itemName = itemName;
        this.trackName = trackName;
    }

    public long getRiskId() {
        return riskId;
    }

    public void setRiskId(long riskId) {
        this.riskId = riskId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String riskItemName) {
        this.itemName = riskItemName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
