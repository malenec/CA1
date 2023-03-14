package facades;

import dtos.PersonDTO;
import dtos.CityInfoDTO;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PersonFacade implements IPersonFacade{

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {}

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public PersonDTO getPersonById(int id) {
        return null;
    }

    @Override
    public PersonDTO getPersonByPhoneNumber(String number) {
        return null;
    }

    @Override
    public List<PersonDTO> getPersonsByZipCode(CityInfoDTO zipCode) {
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

        EntityManager em = getEntityManager();

        CityInfo c = em.find(CityInfo.class, person.getAddressDTO().getZipCode());
        Address a = new Address(person.getAddressDTO().getStreet(), person.getAddressDTO().getAdditionalInfo(), c);
        Person p = new Person(person.getFirstName(), person.getLastName(), person.getEmail());
        p.addAddress(a);
        Phone ph = new Phone(person.getPhoneDTO().getNumber(), person.getPhoneDTO().getDescription());
        ph.addPerson(p);


        try {
            em.getTransaction().begin();
            em.persist(a);
            em.persist(p);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }

        return new PersonDTO(p);
    }    // Denne person indeholder ikke en adresse og en telefon - den bruger en constructor der kun sætter id, navn og mail

    @Override
    public PersonDTO updatePerson(PersonDTO person) {
        return null;
    }

    @Override
    public PersonDTO deletePerson(Long id) {
        return null;
    }
}
