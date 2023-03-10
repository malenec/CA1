package facades;

import dtos.HobbyDTO;
import dtos.ZipCodeDTO;
import entities.Hobby;

import java.util.List;

public interface IZipCodeFacade {

    public ZipCodeDTO getZipCodeById(int zipCodeId);

    //US5
    public List<ZipCodeDTO> getAllZipCodes();
}
