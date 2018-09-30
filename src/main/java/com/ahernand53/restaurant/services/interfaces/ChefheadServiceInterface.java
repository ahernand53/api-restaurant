package com.ahernand53.restaurant.services.interfaces;

import com.ahernand53.restaurant.entity.ChefHeadEntity;

import java.util.List;

public interface ChefheadServiceInterface {

    void save (ChefHeadEntity chefHeadEntity);

    void delete (Long idChefHead);

    void update (ChefHeadEntity chefHeadEntity);

    List<ChefHeadEntity> findAll ();

    ChefHeadEntity findById (Long idChefHead);

    ChefHeadEntity findByIdWarehouse (Long idWarehouse);

}
