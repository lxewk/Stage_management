package nl.kortekaas.Stagemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//@Table(name = "note", schema = "public")
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
    @Column(columnDefinition = "serial", name = "note_id")
    private long id;

    private String text;
    private String sender;
    private String receiver;


    public Note() {}

    public Note(String text, String sender, String receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
