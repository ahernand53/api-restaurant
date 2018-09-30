package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.TypeEntity;
import com.ahernand53.restaurant.repositories.interfaces.TypeDao;
import com.ahernand53.restaurant.services.interfaces.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("typeService")
@Transactional
public class TypeService implements TypeServiceInterface {

    @Autowired
    private TypeDao _typeDao;

    @Override
    public void save (TypeEntity typeEntity) {
        _typeDao.save(typeEntity);
    }

    @Override
    public void delete (Long idType) {
        _typeDao.delete(idType);
    }

    @Override
    public void update (TypeEntity typeEntity) {
        _typeDao.update(typeEntity);
    }

    @Override
    public List<TypeEntity> findAll () {
        return _typeDao.findAll();
    }

    @Override
    public TypeEntity findById (Long idType) {
        return _typeDao.findById(idType);
    }

    @Override
    public TypeEntity findByIdPlate (Long idPlate) {
        return _typeDao.findByIdPlate(idPlate);
    }
}
