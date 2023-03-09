package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Person", indexes = {
        @Index(name = "fk_Person_Address1_idx", columnList = "Address_Address_id")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Person_id", nullable = false)
    private Long person_id;

    @Column(name = "Firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "Lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private Set<Phone> phones = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "Hobby_person",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn(name = "Hobby_id"))
    private Set<Hobby> hobbies = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "Address_id")
    private Address address;

    public Person() {
    }

    public Person(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void addAddress(Address address) {
        this.address = address;
        address.addPerson(this);
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void addHobby(Hobby hobby) {
        this.hobbies.add(hobby);
        hobby.addPerson(this);
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getPerson_id() {
        return person_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id != null && Objects.equals(person_id, person.person_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}