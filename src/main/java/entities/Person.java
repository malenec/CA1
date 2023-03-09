package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Person", indexes = {
        @Index(name = "fk_Person_Address1_idx", columnList = "Address_Address_id")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Person_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Address_Address_id", nullable = false, referencedColumnName = "Address_id")
    private Address addressAddress;



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

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
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

    public Address getAddressAddress() {
        return addressAddress;
    }

    public void setAddressAddress(Address addressAddress) {
        this.addressAddress = addressAddress;
    }

}