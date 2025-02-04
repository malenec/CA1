package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;

import java.util.List;

public interface IHobbyFacade {

    public List<HobbyDTO> getAllHobbies();

    public HobbyDTO getHobbyById(Long hobbyId);

    //US2
    public List<PersonDTO> getPersonsByHobby(HobbyDTO hobby);

    //US4
    public int getTotalNumberOfPersonsByHobby(HobbyDTO hobby);

}
