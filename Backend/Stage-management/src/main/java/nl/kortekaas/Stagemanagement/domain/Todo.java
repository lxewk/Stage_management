package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Todo {

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
    private long todoId;

    private Item item;
    private String doneBy;
    private char priority;
    private boolean check;

    @ManyToMany(mappedBy = "todos")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "todos")
    private Set<Note> notes = new HashSet<>();

    @ManyToMany(mappedBy = "todos")
    private Set<Item> items = new HashSet<>();

    public Todo() {}

    public Todo(Item item) {
        this.item = item;
        this.doneBy = doneBy;
        this.priority = ' ';
        this.check = false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
