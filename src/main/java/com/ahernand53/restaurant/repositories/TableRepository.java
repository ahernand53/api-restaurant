package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.entity.TableEntity;
import com.ahernand53.restaurant.repositories.interfaces.TableDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TableRepository extends AbstractSession implements TableDao {

    @Override
    public void save (TableEntity tableEntity) {
        getSession().save(tableEntity);
    }

    @Override
    public void delete (Long idTable) {
        TableEntity tableEntity = findById(idTable);

        if (tableEntity != null) {
            getSession().delete(tableEntity);
        }
    }

    @Override
    public void update (TableEntity tableEntity) {
        getSession().update(tableEntity);
    }

    @Override
    public List<TableEntity> findAll () {
        return getSession().createQuery("FROM TableEntity ").list();
    }

    @Override
    public TableEntity findById (Long idTable) {
        return getSession().get(TableEntity.class, idTable);
    }

    @Override
    public TableEntity findByIdReservation (Long idReservation) {
        List<Object[]> objects = getSession().createQuery(
                "SELECT tb.id, tb.tableNumber FROM TableEntity tb INNER JOIN ReservationEntity rs WHERE rs.id = :idReservation"
        ).setParameter("idReservation", idReservation).list();

        if (objects.size() > 0) {
            for (Object object : objects) {
                if (object instanceof TableEntity) {
                    return (TableEntity) object;
                }
            }
        }

        return null;
    }
}
