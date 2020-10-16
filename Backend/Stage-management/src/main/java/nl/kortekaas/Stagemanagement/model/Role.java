package nl.kortekaas.Stagemanagement.model;

import nl.kortekaas.Stagemanagement.model.enums.ERole;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
//@Table(name = "role", schema = "public")
public class Role {
    
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial", name = "role_id")
    private long id;

    @Enumerated(EnumType.STRING)
    private ERole name;


    public Role() {}

    public Role(ERole harry) {
        this.name = harry;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

}
