package com.ahernand53.restaurant.services.interfaces;

import com.ahernand53.restaurant.entity.TypeEntity;

import java.util.List;

public interface TypeServiceInterface {

    void save (TypeEntity typeEntity);

    void delete (Long idType);

    void update (TypeEntity typeEntity);

    List<TypeEntity> findAll ();

    TypeEntity findById (Long idType);

    TypeEntity findByIdPlate (Long idPlate);

}
