package entities;

import javax.persistence.*;

@Entity
@Table(name = "Address", indexes = {
        @Index(name = "fk_Address_cityinfo_idx", columnList = "cityinfo_ZipCode")
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityinfo_ZipCode", nullable = false)
    private Cityinfo cityinfoZipcode;

    @Column(name = "Street", nullable = false, length = 45)
    private String street;

    @Column(name = "AdditionalInfo", nullable = false, length = 45)
    private String additionalInfo;

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

}