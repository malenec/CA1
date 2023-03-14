package facades;

import dtos.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Person;
import entities.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em = emf.createEntityManager();


    public static void addPerson(){

        Person p = new Person("Malene", "Christensen", "malene@gmail.com");

        CityInfo userCity = em.find(CityInfo.class, 2800L);

        Address a = new Address("Højløkken", "46", userCity);

        p.addAddress(a);

        Phone ph = new Phone(42752212L, "Home");

        p.addPhone(ph);

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }


    public static void addPerson2() {

//        EntityTransaction tx = em.getTransaction();

        try {
            em.getTransaction().begin();

            // Create a new Address entity
            Address address = new Address();
            address.setStreet("123 Main St.");
            address.setAdditionalInfo("Anytown");
            CityInfo userCity = em.find(CityInfo.class, 2800L);

            address.setZipCode(userCity);

            // Create new Person entities and associate them with the Address
            Person person1 = new Person();
            person1.setFirstName("John");
            person1.setLastName("Johnny");
            person1.setEmail("johnny@gmail.dk");

            person1.addAddress(address);
//            address.addPerson(person1);
            Phone phone = new Phone();
            phone.setId(42752212L);
            phone.setDescription("Home");


            // Persist the Address and associated Person entities
            em.persist(address);
//            person1.addPhone(phone);
            phone.addPerson(person1);
//            em.persist(phone);
            em.persist(person1);
            em.getTransaction().commit();

//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
        } finally {
            em.close();
        }
    }



    public static void main(String[] args) {
        addPerson2();
    }

}
