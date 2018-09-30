package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.WarehouseEntity;
import com.ahernand53.restaurant.repositories.interfaces.WarehouseDao;
import com.ahernand53.restaurant.services.interfaces.WarehouseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("warehouseService")
@Transactional
public class WarehouseService implements WarehouseServiceInterface {

    @Autowired
    private WarehouseDao _warehouseDao;

    @Override
    public void save (WarehouseEntity warehouseEntity) {
        _warehouseDao.save(warehouseEntity);
    }

    @Override
    public void delete (Long idWarehouse) {
        _warehouseDao.delete(idWarehouse);
    }

    @Override
    public void update (WarehouseEntity warehouseEntity) {
        _warehouseDao.update(warehouseEntity);
    }

    @Override
    public List<WarehouseEntity> findAll () {
        return _warehouseDao.findAll();
    }

    @Override
    public WarehouseEntity findById (Long idWarehouse) {
        return _warehouseDao.findById(idWarehouse);
    }

    @Override
    public WarehouseEntity findByIdChefHeah (Long idChefHead) {
        return _warehouseDao.findByIdChefHeah(idChefHead);
    }
}
