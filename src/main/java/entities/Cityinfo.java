package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cityinfo")
public class Cityinfo {
    @Id
    @Column(name = "ZipCode", nullable = false)
    private Long zipCode;

    @Column(name = "City", nullable = false, length = 45)
    private String city;

    @OneToMany(mappedBy = "cityinfo", orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

    public Cityinfo() {
    }

    public Cityinfo(Long zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

}