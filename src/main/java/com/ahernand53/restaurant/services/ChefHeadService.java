package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.ChefHeadEntity;
import com.ahernand53.restaurant.repositories.interfaces.ChefHeadDao;
import com.ahernand53.restaurant.services.interfaces.ChefheadServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chefheadService")
@Transactional
public class ChefHeadService implements ChefheadServiceInterface {

    @Autowired
    private ChefHeadDao _chefheadDao;

    @Override
    public void save (ChefHeadEntity chefHeadEntity) {
        _chefheadDao.save(chefHeadEntity);
    }

    @Override
    public void delete (Long idChefHead) {
        _chefheadDao.delete(idChefHead);
    }

    @Override
    public void update (ChefHeadEntity chefHeadEntity) {
        _chefheadDao.update(chefHeadEntity);
    }

    @Override
    public List<ChefHeadEntity> findAll () {
        return _chefheadDao.findAll();
    }

    @Override
    public ChefHeadEntity findById (Long idChefHead) {
        return _chefheadDao.findById(idChefHead);
    }

    @Override
    public ChefHeadEntity findByIdWarehouse (Long idWarehouse) {
        return _chefheadDao.findByIdWarehouse(idWarehouse);
    }
}
