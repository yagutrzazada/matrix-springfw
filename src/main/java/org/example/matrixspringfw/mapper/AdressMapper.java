package org.example.matrixspringfw.mapper;

import org.example.matrixspringfw.dao.AdressEntity;
import org.example.matrixspringfw.model.AdressDto;

public class AdressMapper {
    public static AdressDto toAdressDto(AdressEntity adressEntity) {
        return new AdressDto(adressEntity.getId(),
                adressEntity.getCity(),
                adressEntity.getStreet());
    }
    public static  AdressEntity toAdressEntity(AdressDto adressDto){
        return  new AdressEntity(null,adressDto.getCity(), adressDto.getStreet());
    }
}
