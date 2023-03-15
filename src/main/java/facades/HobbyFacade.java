package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Hobby;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HobbyFacade implements IHobbyFacade{
    private static HobbyFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private HobbyFacade() {}

    public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<HobbyDTO> getAllHobbies() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Hobby> query = em.createQuery("SELECT h FROM Hobby h", Hobby.class);
        List<Hobby> hobbies = query.getResultList();
        return HobbyDTO.getDtos(hobbies);
    }



    @Override
    public HobbyDTO getHobbyById(Long hobbyId) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, hobbyId);
        if(hobby == null) {
            throw new NullPointerException("The hobby with id: " + hobbyId + " was not found");
        }
        return new HobbyDTO(hobby);


    }

    @Override
    public List<PersonDTO> getPersonsByHobby(HobbyDTO hobby) {
        return null;
    }

    @Override
    public int getTotalNumberOfPersonsByHobby(HobbyDTO hobby) {
        return 0;
    }
}
