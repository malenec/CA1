package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cityinfo")
public class Cityinfo {
    @Id
    @Column(name = "ZipCode", nullable = false)
    private Long id;

    @Column(name = "City", nullable = false, length = 45)
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}