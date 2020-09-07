package nl.kortekaas.Stagemanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    @Column(columnDefinition = "serial")
    private long itemId;

    //Nick: Misschien makkelijker om hier een String van te maken.
    @Enumerated(EnumType.STRING)
    private EDepartment department;

    @Enumerated(EnumType.STRING)
    private EPreset preset;

    private String itemName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("items")
    private User creator;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "todoItem")
    private List<Todo> todos = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "noteItem")
    private List<Note> notes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "riskItem")
    private List<Risk> risk;


    public Item(){}

    public Item(EDepartment department, EPreset preset) {
        this.department = department;
        this.preset = preset;
    }

    public long getId() {
        return itemId;
    }

    public void setId(long itemId) {
        this.itemId = itemId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Risk> getRisk() {
        return risk;
    }

    public void setRisk(List<Risk> risk) {
        this.risk = risk;
    }
}
