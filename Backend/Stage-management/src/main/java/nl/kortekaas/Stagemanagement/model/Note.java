package nl.kortekaas.Stagemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    @Column(columnDefinition = "serial", name = "NOTE_ID")
    private long id;

    private String text;
    private User user;
    private Item item;


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    public Item getItem() {
        return item;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public void setUser(User user) { this.user = user; }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
