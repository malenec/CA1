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

        Cityinfo c = em.find(Cityinfo.class, person.getAddressDTO().getZipCode());
//        Address a = new Address(person.getAddressDTO().getStreet(), person.getAddressDTO().getAdditionalInfo(), c);
//        Phone ph = new Phone(person.getPhoneDTO().getNumber(), person.getPhoneDTO().getDescription(), p);
//        p.addAddress(a);
//        p.addPhone(ph);

        try {
            em.getTransaction().begin();
            em.persist(p);
//            em.flush();



//            em.merge(p);

            em.getTransaction().commit();

        }
        finally {
            em.close();
        }

        return new PersonDTO(p);

    }

    public PersonDTO addAddressFacade(Long id, PersonDTO person) {

        EntityManager em = getEntityManager();
        Person p = em.find(Person.class, id);
        Cityinfo c = em.find(Cityinfo.class, person.getAddressDTO().getZipCode());
        Address a = new Address(person.getAddressDTO().getStreet(), person.getAddressDTO().getAdditionalInfo(), c);
        p.addAddress(a);

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
        return new PersonDTO(p);

    }

    public PersonDTO addPhoneFacade(Long id, PersonDTO person) {

        EntityManager em = getEntityManager();
        Person p = em.find(Person.class, id);
        Phone ph = new Phone(person.getPhoneDTO().getNumber(), person.getPhoneDTO().getDescription(), p);
        p.addPhone(ph);

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }

        return new PersonDTO(p);

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
