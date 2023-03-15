package facades;

import dtos.AddressDTO;
import dtos.PersonDTO;
import dtos.PhoneDTO;
import entities.CityInfo;
import entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.junit.jupiter.api.Assertions.*;

class PersonFacadeTest {

    @PersistenceUnit (unitName = "puTest")

    private static EntityManagerFactory emf;
    private static PersonFacade personFacade;

    PersonDTO p1DTO, p2DTO;

    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        personFacade = PersonFacade.getPersonFacade(emf);
    }


    @BeforeEach
    void setUp() {

        EntityManager em = emf.createEntityManager();

        CityInfo c = new CityInfo(2800L,"Lyngby");
        CityInfo c1 = new CityInfo(4140L,"Borup");

        try {
            em.getTransaction().begin();

            em.createNamedQuery("Phone.deleteAllRows").executeUpdate();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.createNamedQuery("Address.deleteAllRows").executeUpdate();
            em.createNamedQuery("CityInfo.deleteAllRows").executeUpdate();

            em.persist(c);
            em.persist(c1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }


        AddressDTO addressDTO_1 = new AddressDTO("Parkvej", "61", 4140L);
        PhoneDTO phoneDTO_1 = new PhoneDTO(41421359L, "Home");
        p1DTO = new PersonDTO("Musse", "Jensen", "test@gmail.com", addressDTO_1, phoneDTO_1);
        personFacade.addPerson(p1DTO);



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPersonByPhoneNumber() {
    }

    @Test
    void getPersonsByZipCode() {
    }

    @Test
    void addHobbyToPerson() {
    }

    @Test
    void deleteHobbyFromPerson() {
    }

    @Test
    void getPersonById() {
        assertEquals(1, personFacade.getPersonById(p1DTO.getId()).getId());

    }


    @Test
    void addPerson() {

        AddressDTO addressDTO_1 = new AddressDTO("Højløkken", "46", 2800L);
        PhoneDTO phoneDTO_1 = new PhoneDTO(42752212L, "Home");
        PersonDTO personDTO_1 = new PersonDTO("Malene", "Christensen", "malene@gmail.com", addressDTO_1, phoneDTO_1);

        assertEquals("Malene", personFacade.addPerson(personDTO_1).getFirstName());

    }

    @Test
    void updatePerson() {



//        personFacade.getPersonById(p1DTO.getId()).setFirstName("Jens");
//
//        personFacade.updatePerson(p1DTO);
//
//        assertEquals("Jens", personFacade.getPersonById(p1DTO.getId()).getFirstName());



    }

    @Test
    void deletePerson() {
    }
}