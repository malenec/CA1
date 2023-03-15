package dtos;

import entities.Person;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO addressDTO;
    private Set<PhoneDTO> phoneDTOSet = new LinkedHashSet<>();
    private Set<HobbyDTO> hobbyDTOSet = new LinkedHashSet<>();

    public PersonDTO(Person person) {
        if(person.getId() != null)
            this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.addressDTO = new AddressDTO(person.getAddress().getStreet(), person.getAddress().getAdditionalInfo(), person.getAddress().getCityInfo().getZipCode());
        this.phoneDTOSet = person.getPhones().stream().map(phone -> new PhoneDTO(phone.getNumber(), phone.getDescription())).collect(Collectors.toSet());
        this.hobbyDTOSet = person.getHobbies().stream().map(hobby -> new HobbyDTO(hobby.getName(), hobby.getWikiLink(), hobby.getCategory(), hobby.getType())).collect(Collectors.toSet());
    }


    public PersonDTO(String firstName, String lastName, String email, AddressDTO addressDTO, Set<PhoneDTO> phoneDTOSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressDTO = addressDTO;
        this.phoneDTOSet = phoneDTOSet;
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

    public Set<PhoneDTO> getPhoneDTOSet() {
        return phoneDTOSet;
    }

    public void addPhoneDTOToSet(PhoneDTO phoneDTO) {
        this.phoneDTOSet.add(phoneDTO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<HobbyDTO> getHobbyDTOSet() {
        return hobbyDTOSet;
    }

    public void setHobbyDTOSet(Set<HobbyDTO> hobbyDTOSet) {
        this.hobbyDTOSet = hobbyDTOSet;
    }

    public void addHobbyDTOToSet(HobbyDTO hobbyDTO) {
        this.hobbyDTOSet.add(hobbyDTO);
    }


}
