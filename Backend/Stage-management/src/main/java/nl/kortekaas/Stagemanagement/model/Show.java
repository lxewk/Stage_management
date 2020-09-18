package nl.kortekaas.Stagemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Show {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial", name = "SHOW_ID")
    private long id;

    private String name;
    private String posterArt;
    private String stagemanager;


    public Show() {}

    public Show(String name, String posterArt, String stagemanager) {
        this.name = name;
        this.posterArt = posterArt;
        this.stagemanager = stagemanager;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterArt() {
        return posterArt;
    }

    public void setPosterArt(String posterArt) {
        this.posterArt = posterArt;
    }

    public String getStagemanager() {
        return stagemanager;
    }

    public void setStagemanager(String stagemanager) {
        this.stagemanager = stagemanager;
    }

}
