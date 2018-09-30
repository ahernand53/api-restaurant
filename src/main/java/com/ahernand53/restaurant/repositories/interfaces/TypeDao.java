package com.ahernand53.restaurant.repositories.interfaces;

import com.ahernand53.restaurant.entity.TypeEntity;

import java.util.List;

public interface TypeDao {

    void save (TypeEntity typeEntity);

    void delete (Long idType);

    void update (TypeEntity typeEntity);

    List<TypeEntity> findAll ();

    TypeEntity findById (Long idType);

    TypeEntity findByIdPlate (Long idPlate);

}
