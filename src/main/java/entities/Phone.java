package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Phone", indexes = {
        @Index(name = "fk_Phone_Person1_idx", columnList = "Person_id"),
        @Index(name = "Number_UNIQUE", columnList = "Number", unique = true)
})
public class Phone {
    @Id
    @Column(name = "Number", nullable = false)
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Person_id", nullable = false, referencedColumnName = "Person_id")
    private Person person;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

    public Phone() {
    }

    public Phone(Long number, String description, Person person) {
        this.number = number;
        this.description = description;
        this.person = person;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number != null && Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}