package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.repositories.interfaces.PlateDao;
import com.ahernand53.restaurant.entity.PlateEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlateRepository extends AbstractSession implements PlateDao {

    @Override
    public void save (PlateEntity plateEntity) {
        getSession().persist(plateEntity);
    }

    @Override
    public void delete (Long idPlate) {
        PlateEntity plateEntity = findById(idPlate);
        if (plateEntity != null) {
            getSession().delete(plateEntity);
        }
    }

    @Override
    public void update (PlateEntity plateEntity) {
        getSession().update(plateEntity);
    }

    @Override
    public List<PlateEntity> findAll () {
        return getSession().createQuery("FROM PlateEntity ").list();
    }

    @Override
    public PlateEntity findById (Long idPlate) {
        return getSession().get(PlateEntity.class, idPlate);
    }

    @Override
    public List<PlateEntity> findByIdType (Long idType) {
        return getSession().createQuery(
                "FROM PlateEntity pl WHERE pl.typesByIdType = :idType"
        ).list();
    }
}
