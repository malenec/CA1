package facades;

import dtos.PersonDTO;
import dtos.CityinfoDTO;
import dtos.RenameMeDTO;
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
    public List<PersonDTO> getPersonsByZipCode(CityinfoDTO zipCode) {
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
        Person p = new Person(person.getFirstName(), person.getLastName(), person.getEmail());
        Address a = new Address(person.getAddressDTO().getStreet(), person.getAddressDTO().getAdditionalInfo(), person.getAddressDTO().getZipCode());
        Phone ph = new Phone(person.getPhoneDTO().getNumber(), person.getPhoneDTO().getDescription());
        p.addAddress(a);
        p.addPhone(ph);
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(p);

    }

    public RenameMeDTO create(RenameMeDTO rm){
        RenameMe rme = new RenameMe(rm.getDummyStr1(), rm.getDummyStr2());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RenameMeDTO(rme);
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
