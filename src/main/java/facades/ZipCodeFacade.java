package facades;

import dtos.CityInfoDTO;
import dtos.PersonDTO;
import entities.CityInfo;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ZipCodeFacade implements IZipCodeFacade{

    private static ZipCodeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private ZipCodeFacade() {}

    public static ZipCodeFacade getZipCodeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ZipCodeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public CityInfoDTO getZipCodeById(int zipCodeId) {
        return null;
    }

    @Override
    public List<CityInfoDTO> getAllZipCodes() {

            EntityManager em = emf.createEntityManager();
            TypedQuery<CityInfo> query = em.createQuery("SELECT c FROM CityInfo c", CityInfo.class);
            List<CityInfo> cityInfos = query.getResultList();
            return CityInfoDTO.getDtos(cityInfos);
        }

}
