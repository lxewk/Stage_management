package nl.kortekaas.Stagemanagement.model;

import nl.kortekaas.Stagemanagement.model.enums.EDepartment;
import nl.kortekaas.Stagemanagement.model.enums.EPreset;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial", name = "item_id")
    private long id;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private EDepartment department;

    @Enumerated(EnumType.STRING)
    private EPreset preset;


    public Item() {}

    private Item(String itemName, EDepartment department) {
        this.itemName = itemName;
        this.department = department;
        this.preset = getPreset();
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EDepartment department) {
        this.department = department;
    }

    public EPreset getPreset() {
        return preset;
    }

    public void setPreset(EPreset preset) {
        this.preset = preset;
    }
}
