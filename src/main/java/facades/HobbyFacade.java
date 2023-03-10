package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;

import java.util.List;

public class HobbyFacade implements IHobbyFacade{
    @Override
    public List<HobbyDTO> getAllHobbies() {
        return null;
    }

    @Override
    public HobbyDTO getHobbyById(int hobbyId) {
        return null;
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
