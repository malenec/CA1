package dtos;

import entities.CityInfo;
import entities.Hobby;

import java.util.ArrayList;
import java.util.List;

public class CityInfoDTO {

    private String city;
    private Long zipCode;

    public CityInfoDTO(CityInfo cityInfo) {
        this.city = cityInfo.getCity();
        this.zipCode = cityInfo.getZipCode();
    }

    public CityInfoDTO(String city, Long zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public static List<CityInfoDTO> getDtos(List<CityInfo> cityInfos) {
        List<CityInfoDTO> cityInfosDTOS = new ArrayList();
        cityInfos.forEach(cityInfo->cityInfosDTOS.add(new CityInfoDTO(cityInfo)));
        return cityInfosDTOS;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
}
