package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "Phone.deleteAllRows", query = "delete from Phone p")
})
public class Phone {
    @Id
    @Column(name = "number", nullable = false)
    private Long id;

    @Size(max = 45)
    @NotNull
    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Phone() {
    }

    public Phone(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void addPerson(Person person) {
        this.person = person;
        person.addPhone(this);
    }

}