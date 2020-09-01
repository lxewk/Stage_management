package nl.kortekaas.Stagemanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Note {

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
    private long noteId;

    private User activeUser;
    private User receiverUser;
    private Todo activeTODO;
    private char priority;

    @ManyToMany(mappedBy = "note")
    private Set<User> users = new HashSet<>();

    @OneToOne(mappedBy = "todo_note")
    private Todo hasNote;

    public Note(){}

    public Note(User activeUser, User receiverUser, Todo activeTODO) {
        this.activeUser = activeUser;
        this.receiverUser = receiverUser;
        this. activeTODO = activeTODO;
        this.priority = ' ';
    }

    public void sendNote(User receiverUser, User activeUser) {
        System.out.println(receiverUser + " You've got a note");
        int toSend = receiverUser.getReceivedNote();
        receiverUser.setReceivedNote(toSend);
    }

    public User getActiveRole() {
        return activeUser;
    }

    public void setActiveRole(User activeUser) {
        this.activeUser = activeUser;
    }

    public User getReceiverRole() {
        return receiverUser;
    }

    public void setReceiverRole(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public Todo getActiveTODO() {
        return activeTODO;
    }

    public void setActiveTODO(Todo activeTODO) {
        this.activeTODO = activeTODO;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }
}
