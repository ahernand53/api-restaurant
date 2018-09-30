package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.entity.WarehouseEntity;
import com.ahernand53.restaurant.repositories.AbstractSession;
import com.ahernand53.restaurant.repositories.interfaces.WarehouseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class WarehouseRepository extends AbstractSession implements WarehouseDao {

    @Override
    public void save (WarehouseEntity warehouseEntity) {
        getSession().persist(warehouseEntity);
    }

    @Override
    public void delete (Long idWarehouse) {
        WarehouseEntity warehouseEntity = findById(idWarehouse);
        if (warehouseEntity != null) {
            getSession().delete(warehouseEntity);
        }
    }

    @Override
    public void update (WarehouseEntity warehouseEntity) {
        getSession().update(warehouseEntity);
    }

    @Override
    public List<WarehouseEntity> findAll () {
        return getSession().createQuery("FROM WarehouseEntity ").list();
    }

    @Override
    public WarehouseEntity findById (Long idWarehouse) {
        return getSession().get(WarehouseEntity.class, idWarehouse);
    }

    @Override
    public WarehouseEntity findByIdChefHeah (Long idChefHead) {
        List<Object[]> objects = getSession().createQuery(
                "SELECT wh.id, wh.name, wh.phone, wh.address, wh.numberTables, wh.chefHeadsByIdChefHead " +
                        "FROM WarehouseEntity wh " +
                        "JOIN ChefHeadEntity h on wh.chefHeadsByIdChefHead.id = h.id " +
                        "WHERE h.id = :idChefHead"
        ).setParameter("idChefHead", idChefHead).list();

        if (objects.size() > 0) {
            for (Object object : objects) {
                if (object instanceof WarehouseEntity) {
                    return (WarehouseEntity) object;
                }
            }
        }

        return null;
    }
}
