package dtos;

import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO addressDTO;
    private PhoneDTO phoneDTO;

    public PersonDTO(Person person) {
        if(person.getId() != null)
            this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.addressDTO = new AddressDTO(person.getAddress().getStreet(), person.getAddress().getAdditionalInfo(), person.getAddress().getCityInfo().getZipCode());
        this.phoneDTO = new PhoneDTO(person.getPhone().getNumber(), person.getPhone().getDescription());
    }

    public PersonDTO(String firstName, String lastName, String email, AddressDTO addressDTO, PhoneDTO phoneDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressDTO = addressDTO;
        this.phoneDTO = phoneDTO;
    }

    public static List<PersonDTO> getDtos(List<Person> persons) {
        List<PersonDTO> personDtos = new ArrayList();
        persons.forEach(person->personDtos.add(new PersonDTO(person)));
        return personDtos;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public PhoneDTO getPhoneDTO() {
        return phoneDTO;
    }

    public void setPhoneDTO(PhoneDTO phoneDTO) {
        this.phoneDTO = phoneDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
