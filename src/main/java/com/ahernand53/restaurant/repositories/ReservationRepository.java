package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.repositories.interfaces.ReservationDao;
import com.ahernand53.restaurant.entity.ReservationEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReservationRepository extends AbstractSession implements ReservationDao {

    @Override
    public void save (ReservationEntity reservationEntity) {
        getSession().persist(reservationEntity);
    }

    @Override
    public void delete (Long idReservation) {

    }

    @Override
    public void update (ReservationEntity reservationEntity) {
        getSession().update(reservationEntity);
    }

    @Override
    public List<ReservationEntity> findAll () {
        return getSession().createQuery("FROM ReservationEntity ").list();
    }

    @Override
    public ReservationEntity findById (Long idReservation) {
        return getSession().get(ReservationEntity.class, idReservation);
    }

    @Override
    public ReservationEntity findByIdClient (Long idClient) {
        List<Object[]> objects = getSession().createQuery(
                "FROM ReservationEntity rs "
                        + " WHERE rs.clientsByIdClient = :idClient "
        ).setParameter("idClient", idClient).list();

        if (objects.size() > 0) {
            for (Object[] objects1 : objects) {
                if (objects instanceof ReservationEntity) {
                    return (ReservationEntity) objects;
                }
            }
        }

        return null;

    }

    @Override
    public List<ReservationEntity> findAllByIdWarehouse (Long idWarehouse) {
        return getSession().createQuery(
                "FROM ReservationEntity rs"
                        + " WHERE rs.warehouseByIdWarehouse = :idWarehouse"
        ).setParameter("idWarehouse", idWarehouse).list();
    }
}
