package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "CityInfo.deleteAllRows", query = "delete from CityInfo c")
})
public class CityInfo {
    @Id
    @Column(name = "zipCode", nullable = false)
    private Long zipCode;

    @Size(max = 45)
    @NotNull
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @OneToMany(mappedBy = "zipCode")
    private Set<Address> addresses = new LinkedHashSet<>();

    public CityInfo() {
    }

    public CityInfo(Long zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

}