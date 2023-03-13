package facades;

import dtos.CityinfoDTO;

import java.util.List;

public interface IZipCodeFacade {

    public CityinfoDTO getZipCodeById(int zipCodeId);

    //US5
    public List<CityinfoDTO> getAllZipCodes();
}
