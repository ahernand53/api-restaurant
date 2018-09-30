package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.PlateEntity;
import com.ahernand53.restaurant.repositories.interfaces.PlateDao;
import com.ahernand53.restaurant.services.interfaces.PlateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("plateService")
@Transactional
public class PlateService implements PlateServiceInterface {

    @Autowired
    private PlateDao _plateDao;

    @Override
    public void save (PlateEntity plateEntity) {
        _plateDao.save(plateEntity);
    }

    @Override
    public void delete (Long idPlate) {
        _plateDao.delete(idPlate);
    }

    @Override
    public void update (PlateEntity plateEntity) {
        _plateDao.update(plateEntity);
    }

    @Override
    public List<PlateEntity> findAll () {
        return _plateDao.findAll();
    }

    @Override
    public PlateEntity findById (Long idPlate) {
        return _plateDao.findById(idPlate);
    }

    @Override
    public List<PlateEntity> findByIdType (Long idType) {
        return _plateDao.findByIdType(idType);
    }
}
