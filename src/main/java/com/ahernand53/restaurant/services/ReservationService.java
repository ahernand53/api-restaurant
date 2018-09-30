package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.ReservationEntity;
import com.ahernand53.restaurant.repositories.interfaces.ReservationDao;
import com.ahernand53.restaurant.services.interfaces.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reservationService")
@Transactional
public class ReservationService implements ReservationServiceInterface {

    @Autowired
    private ReservationDao _reservationDao;

    @Override
    public void save (ReservationEntity reservationEntity) {
        _reservationDao.save(reservationEntity);
    }

    @Override
    public void delete (Long idReservation) {
        _reservationDao.delete(idReservation);
    }

    @Override
    public void update (ReservationEntity reservationEntity) {
        _reservationDao.update(reservationEntity);
    }

    @Override
    public List<ReservationEntity> findAll () {
        return _reservationDao.findAll();
    }

    @Override
    public ReservationEntity findById (Long idReservation) {
        return _reservationDao.findById(idReservation);
    }

    @Override
    public ReservationEntity findByIdClient (Long idClient) {
        return null;
    }

    @Override
    public List<ReservationEntity> findAllByIdWarehouse (Long idWarehouse) {
        return _reservationDao.findAllByIdWarehouse(idWarehouse);
    }
}
