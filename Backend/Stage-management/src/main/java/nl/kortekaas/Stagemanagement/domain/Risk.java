package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "TRACK_RISK",
    joinColumns = @JoinColumn(name = "RISK_ID"),
    inverseJoinColumns = @JoinColumn(name = "TRACK_ID"))
    private Set<Track> tracks = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ITEM_RISK",
            joinColumns = @JoinColumn(name = "RISK_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private Set<Item> items = new HashSet<>();


    public Risk() {}

    public Risk(String itemName) {
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

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
