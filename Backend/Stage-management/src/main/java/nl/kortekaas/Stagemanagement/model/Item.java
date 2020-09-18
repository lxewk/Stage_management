package nl.kortekaas.Stagemanagement.model;

import nl.kortekaas.Stagemanagement.model.enums.EDepartment;
import nl.kortekaas.Stagemanagement.model.enums.EPreset;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    @Column(columnDefinition = "serial", name = "ITEM_ID")
    private long id;

    private String itemName;

    private Set<Risk> risks;
    private Set<Todo> todos;
    private Set<Note> notes;

    @Enumerated(EnumType.STRING)
    private EDepartment department;

    @Enumerated(EnumType.STRING)
    private EPreset preset;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    public Set<Todo> getTodos() {
        return todos;
    }

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    public Set<Risk> getRisks() {
        return risks;
    }

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    public Set<Note> getNotes() {
        return notes;
    }


    public Item() {}


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public Item(EDepartment department) { this.department = department; }

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setRisks(Set<Risk> risks) { this.risks = risks; }

    public void setTodos(Set<Todo> todos) { this.todos = todos; }

    public void setNotes(Set<Note> notes) { this.notes = notes; }

}
