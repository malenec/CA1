package dtos;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String addressAdditionalInfo;
    private Long zipCode;
    private Long phoneNumber;
    private String phoneDescription;


    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String email, String street, String addressAdditionalInfo, Long zipCode, Long phoneNumber, String phoneDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.addressAdditionalInfo = addressAdditionalInfo;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.phoneDescription = phoneDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressAdditionalInfo() {
        return addressAdditionalInfo;
    }

    public void setAddressAdditionalInfo(String addressAdditionalInfo) {
        this.addressAdditionalInfo = addressAdditionalInfo;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }
}
