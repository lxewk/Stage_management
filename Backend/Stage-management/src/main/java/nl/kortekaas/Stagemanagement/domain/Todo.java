package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;



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

    private String doneBy;
    private char priority;
    private boolean check;

    @ManyToMany(mappedBy = "todo_s")
    private List<User> users;

    @ManyToOne
    private Item todoItem;

    public Todo() {}


    public long getId() {
        return todoId;
    }

    public void setId(long todoId) {
        this.todoId = todoId;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Item getItem() {
        return todoItem;
    }

    public void setItem(Item item) {
        this.todoItem = item;
    }
}
