package nl.kortekaas.Stagemanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private EDepartment department;

    @Enumerated(EnumType.STRING)
    private EPreset preset;

    private User managerRole;
    private String itemName;
    private Todo todo;
    private Risk risk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("items")
    private User item_user;

    public Item(){}

    public Item(User managerRole, String itemName, EDepartment department) {
        this.managerRole = managerRole;
        this.itemName = itemName;
        this.department = department;
        this.preset = preset;
        Item todoItem = new Item(managerRole, itemName, department);
        this.todo = new Todo(todoItem);
        this.risk = risk;
    }

    public void addPhoto(){
        System.out.println("here should be a picture");
    }

    public void addVideo(){
        System.out.println("here should be a video");
    }

    public User getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(User managerRole) {
        this.managerRole = managerRole;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EDepartment section) {
        this.department = section;
    }

    public EPreset getPreset() {
        return preset;
    }

    public void setPreset(EPreset preset) {
        this.preset = preset;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
}
