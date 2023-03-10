package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Hobby;

import java.util.List;

public interface IHobbyFacade {

    public List<HobbyDTO> getAllHobbies();

    public HobbyDTO getHobbyById(int hobbyId);

    //US2
    public List<PersonDTO> getPersonsByHobby(HobbyDTO hobby);

    //US4
    public int getTotalNumberOfPersonsByHobby(HobbyDTO hobby);

}
