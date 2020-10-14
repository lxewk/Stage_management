package nl.kortekaas.Stagemanagement.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "risk", schema = "public")
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
    @Column(columnDefinition = "serial", name = "risk_id")
    private long id;

    private String possibleRisks;


    public Risk() {}


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPossibleRisks() { return possibleRisks; }

    public void setPossibleRisks(String possibleRisks) { this.possibleRisks = possibleRisks; }



}
