package com.ahernand53.restaurant.repositories.interfaces;

import com.ahernand53.restaurant.entity.TableEntity;

import java.util.List;

public interface TableDao {

    void save (TableEntity tableEntity);

    void delete (Long idTable);

    void update (TableEntity tableEntity);

    List<TableEntity> findAll ();

    TableEntity findById(Long idTable);

    TableEntity findByIdReservation (Long idReservation);

}
