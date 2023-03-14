package facades;

import dtos.CityInfoDTO;

import java.util.List;

public interface IZipCodeFacade {

    public CityInfoDTO getZipCodeById(int zipCodeId);

    //US5
    public List<CityInfoDTO> getAllZipCodes();
}
