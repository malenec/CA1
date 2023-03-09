package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Address", indexes = {
        @Index(name = "fk_Address_cityinfo_idx", columnList = "cityinfo_ZipCode")
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_id", nullable = false)
    private Long address_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityinfo_ZipCode", nullable = false)
    private Cityinfo cityinfoZipcode;

    @Column(name = "Street", nullable = false, length = 45)
    private String street;

    @Column(name = "AdditionalInfo", nullable = false, length = 45)
    private String additionalInfo;

    @OneToMany(mappedBy = "address", orphanRemoval = true)
    @JoinColumn(name = "Address_id")
    private Set<Person> persons = new LinkedHashSet<>();

    public Address() {
    }

    public Address(Cityinfo cityinfoZipcode, String street, String additionalInfo) {
        this.cityinfoZipcode = cityinfoZipcode;
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Cityinfo getCityinfoZipcode() {
        return cityinfoZipcode;
    }

    public void setCityinfoZipcode(Cityinfo cityinfoZipcode) {
        this.cityinfoZipcode = cityinfoZipcode;
    }

    public Long getAddress_id() {
        return address_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return address_id != null && Objects.equals(address_id, address.address_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}