package nl.kortekaas.Stagemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    private String possibleRisks;

    @ManyToOne
    private Item riskItem;

    public long getRiskId() {
        return riskId;
    }

    public void setRiskId(long riskId) {
        this.riskId = riskId;
    }

    public String getPossibleRisks() {
        return possibleRisks;
    }

    public void setPossibleRisks(String possibleRisks) {
        this.possibleRisks = possibleRisks;
    }

    public Item getRiskItem() {
        return riskItem;
    }

    public void setRiskItem(Item riskItem) {
        this.riskItem = riskItem;
    }
}
