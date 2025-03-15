package org.example.matrixspringfw.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspringfw.dao.AdressEntity;
import org.example.matrixspringfw.dao.AdressRepository;
import org.example.matrixspringfw.mapper.AdressMapper;
import org.example.matrixspringfw.model.AdressDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdressService {
   public final   AdressRepository addressRepository;

    public void createAddress(AdressDto addressDto) {
        AdressEntity entity=AdressMapper.toAdressEntity(addressDto);
        addressRepository.save(entity);
    }

}
