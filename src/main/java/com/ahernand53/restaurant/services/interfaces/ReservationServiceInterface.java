package com.ahernand53.restaurant.services.interfaces;

import com.ahernand53.restaurant.entity.ReservationEntity;

import java.util.List;

public interface ReservationServiceInterface {

    void save (ReservationEntity reservationEntity);

    void delete (Long idReservation);

    void update (ReservationEntity reservationEntity);

    List<ReservationEntity> findAll ();

    ReservationEntity findById (Long idReservation);

    ReservationEntity findByIdClient (Long idClient);

    List<ReservationEntity> findAllByIdWarehouse (Long idWarehouse);

}
