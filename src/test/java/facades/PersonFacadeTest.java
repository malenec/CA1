package facades;

import dtos.AddressDTO;
import dtos.PersonDTO;
import dtos.PhoneDTO;
import entities.CityInfo;
import org.junit.jupiter.api.AfterEach;
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
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puTest");
    private static PersonFacade personFacade;

    @BeforeEach
    void setUp() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        personFacade = PersonFacade.getPersonFacade(emf);

        EntityManager em = emf.createEntityManager();
        CityInfo c = new CityInfo(2800L,"Lyngby");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("CityInfo.deleteAllRows").executeUpdate();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getPersonByPhoneNumber() {
//    }
//
//    @Test
//    void getPersonsByZipCode() {
//    }
//
//    @Test
//    void addHobbyToPerson() {
//    }
//
//    @Test
//    void deleteHobbyFromPerson() {
//    }


    @Test
    void addPerson() {

        AddressDTO addressDTO_1 = new AddressDTO("Højløkken", "46", 2800L);
        PhoneDTO phoneDTO_1 = new PhoneDTO(42752212L, "Home");
        PersonDTO personDTO_1 = new PersonDTO("Malene", "Christensen", "malene@gmail.com", addressDTO_1, phoneDTO_1);

        assertEquals("Malene", personFacade.addPerson(personDTO_1).getFirstName());

    }

//    @Test
//    void updatePerson() {
//    }
//
//    @Test
//    void deletePerson() {
//    }
}