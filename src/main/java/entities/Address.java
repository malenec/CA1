package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long address_id;

    @Size(max = 45)
    @NotNull
    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Size(max = 45)
    @NotNull
    @Column(name = "additionalInfo", nullable = false, length = 45)
    private String additionalInfo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zipCode", nullable = false)
    private CityInfo zipCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
    private Set<Person> people = new LinkedHashSet<>();

    public Address() {
    }



    public Address(String street, String additionalInfo, CityInfo zipCode) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CityInfo getZipCode() {
        return zipCode;
    }

    public void setZipCode(CityInfo zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {

        this.people.add(person);
    }

}