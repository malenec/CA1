package facades;

import dtos.PersonDTO;
import dtos.CityInfoDTO;

import java.util.List;

public interface IPersonFacade {

    public PersonDTO getPersonById(int id);

    //US1
    public PersonDTO getPersonByPhoneNumber(String number);

    //US3
    public List<PersonDTO> getPersonsByZipCode(CityInfoDTO zipCode);

    //US6
    public PersonDTO addHobbyToPerson(PersonDTO person, int hobbyId);

    //US7
    public PersonDTO deleteHobbyFromPerson(PersonDTO person, int hobbyId);

    //US8
    public PersonDTO addPerson(PersonDTO person);

    //US9
    public PersonDTO updatePerson(PersonDTO person);

    //US10
    public PersonDTO deletePerson(Long id);



}
