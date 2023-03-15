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
    private Long number;

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

    public Phone(Long number, String description) {
        this.number = number;
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    public void addPersonToPhone(Person person) {
        this.person = person;
    }



}