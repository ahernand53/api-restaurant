package com.ahernand53.restaurant.repositories.interfaces;

import com.ahernand53.restaurant.entity.PlateEntity;

import java.util.List;

public interface PlateDao {

    void save (PlateEntity plateEntity);

    void delete (Long idPlate);

    void update (PlateEntity plateEntity);

    List<PlateEntity> findAll ();

    PlateEntity findById (Long idPlate);

    List<PlateEntity> findByIdType(Long idType);

}
