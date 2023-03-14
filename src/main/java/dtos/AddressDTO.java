package dtos;

public class AddressDTO {

    private String street;
    private String additionalInfo;
    private Long zipCode;

    public AddressDTO(String street, String additionalInfo, Long zipCode) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
    }

    public Long getZipCode() {
        return zipCode;
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


}
