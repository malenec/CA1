package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.CityInfoDTO;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
    public PersonDTO getPersonById(Long id) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        if(person == null) {
            throw new NullPointerException("The person with id: " + id + " was not found");
        }
        return new PersonDTO(person);
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
    public PersonDTO addHobbyToPerson(Long hobbyId, Long personId) {
        EntityManager em = getEntityManager();
        Person p = em.find(Person.class, personId);
        Hobby h = em.find(Hobby.class, hobbyId);
        p.addHobbyToPerson(h);

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
    public PersonDTO deleteHobbyFromPerson(Long hobbyId, Long personId) {

        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, personId);
        Hobby h = em.find(Hobby.class, hobbyId);

        if(p == null){
            throw new IllegalArgumentException("No person with that id: " + personId + " exists");
        }

        p.getHobbies().forEach((hobby)->
        {
            if(hobby.getId() == h.getId()){
                p.removeHobbyFromPerson(hobby);
            }
        });

        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return new PersonDTO(p);
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {

        EntityManager em = getEntityManager();

        CityInfo c = em.find(CityInfo.class, personDTO.getAddressDTO().getZipCode());
        Address a = new Address(personDTO.getAddressDTO().getStreet(), personDTO.getAddressDTO().getAdditionalInfo(), c);
        Person p = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail());
        Set<Phone> phones = new LinkedHashSet<>();
        personDTO.getPhoneDTOSet().forEach(phoneDTO -> phones.add(new Phone(phoneDTO.getNumber(), phoneDTO.getDescription())));
        p.addAddress(a);
        p.addPhoneSet(phones);


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
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, personDTO.getId());
        if(person == null) {
            throw new NullPointerException("The person with id: " + personDTO.getId() + " was not found");
        }
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setEmail(personDTO.getEmail());

        CityInfo c = em.find(CityInfo.class, personDTO.getAddressDTO().getZipCode());
        Address a = new Address(personDTO.getAddressDTO().getStreet(), personDTO.getAddressDTO().getAdditionalInfo(), c);
        person.addAddress(a);

        Set<Phone> phones = new LinkedHashSet<>();
        personDTO.getPhoneDTOSet().forEach(phoneDTO -> phones.add(new Phone(phoneDTO.getNumber(), phoneDTO.getDescription())));
        person.addPhoneSet(phones);


        Set<Hobby> hobbies = new LinkedHashSet<>();
        personDTO.getHobbyDTOSet().forEach(hobbyDTO -> hobbies.add(new Hobby(hobbyDTO.getHobbyName(), hobbyDTO.getWikiLink(), hobbyDTO.getCategory(), hobbyDTO.getType())));
        person.addHobbySet(hobbies);

        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO deletePerson(Long id) {

        //rækkefølge: phone, hobby_person, person, address

            EntityManager em = emf.createEntityManager();
            Person p = em.find(Person.class, id);
            if(p == null){
                throw new IllegalArgumentException("No person with that id: " + id + " exists");
            }
            try{
                em.getTransaction().begin();
                p.getPhones().forEach((phone)->em.remove(phone));
                Address a = p.getAddress();
                em.remove(p);
                em.remove(a);

                em.getTransaction().commit();
            }finally {
                em.close();
            }

        return null;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        return PersonDTO.getDtos(persons);
    }



}
