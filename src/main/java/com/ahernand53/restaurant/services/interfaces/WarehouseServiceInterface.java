package com.ahernand53.restaurant.services.interfaces;

import com.ahernand53.restaurant.entity.WarehouseEntity;

import java.util.List;

public interface WarehouseServiceInterface {

    void save (WarehouseEntity warehouseEntity);

    void delete (Long idWarehouse);

    void update (WarehouseEntity warehouseEntity);

    List<WarehouseEntity> findAll ();

    WarehouseEntity findById (Long idWarehouse);

    WarehouseEntity findByIdChefHeah (Long idChefHead);

}
