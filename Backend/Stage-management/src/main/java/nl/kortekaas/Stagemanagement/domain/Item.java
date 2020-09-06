package nl.kortekaas.Stagemanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private Set<Todo> todos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    private Set<Note> notes;


    public Item(){}


    // NICK: In controller & Service klasse
    public void addPhoto(){
        System.out.println("here should be a picture");
    }

    // NICK: In controller & Service klasse
    public void addVideo(){
        System.out.println("here should be a video");
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User managerRole) {
        this.creator = managerRole;
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
}
