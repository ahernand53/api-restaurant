package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.repositories.interfaces.ChefHeadDao;
import com.ahernand53.restaurant.entity.ChefHeadEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ChefHeadRepository extends AbstractSession implements ChefHeadDao {

    @Override
    public void save (ChefHeadEntity chefHeadEntity) {
        getSession().persist(chefHeadEntity);
    }

    @Override
    public void delete (Long idChefHead) {
        ChefHeadEntity chefHeadEntity = findById(idChefHead);
        if (chefHeadEntity != null) {
            getSession().delete(chefHeadEntity);
        }
    }

    @Override
    public void update (ChefHeadEntity chefHeadEntity) {
        getSession().update(chefHeadEntity);
    }

    @Override
    public List<ChefHeadEntity> findAll () {
        return getSession().createQuery("FROM ChefHeadEntity").list();
    }

    @Override
    public ChefHeadEntity findById (Long idChefHead) {
        return getSession().get(ChefHeadEntity.class, idChefHead);
    }

    @Override
    public ChefHeadEntity findByIdWarehouse (Long idWarehouse) {
        List<Object[]> objects = getSession().createQuery(
                "FROM ChefHeadEntity chef " +
                        "WHERE chef.warehousesById = :idWarehouse"
        ).list();

        if (objects.size() > 0) {
            for( Object objects1 : objects) {
                if (objects1 instanceof ChefHeadEntity) {
                    return (ChefHeadEntity) objects1;
                }
            }
        }

        return null;
    }
}
