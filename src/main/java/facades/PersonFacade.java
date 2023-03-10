package facades;

import dtos.PersonDTO;
import dtos.ZipCodeDTO;

import java.util.List;

public class PersonFacade implements IPersonFacade{

    @Override
    public PersonDTO getPersonById(int id) {
        return null;
    }

    @Override
    public PersonDTO getPersonByPhoneNumber(String number) {
        return null;
    }

    @Override
    public List<PersonDTO> getPersonsByZipCode(ZipCodeDTO zipCode) {
        return null;
    }

    @Override
    public PersonDTO addHobbyToPerson(PersonDTO person, int hobbyId) {
        return null;
    }

    @Override
    public PersonDTO deleteHobbyFromPerson(PersonDTO person, int hobbyId) {
        return null;
    }

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        return null;
    }

    @Override
    public PersonDTO updatePerson(PersonDTO person) {
        return null;
    }

    @Override
    public PersonDTO deletePerson(Long id) {
        return null;
    }
}
