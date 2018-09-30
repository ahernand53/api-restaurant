package com.ahernand53.restaurant.repositories.interfaces;

import com.ahernand53.restaurant.entity.ClientEntity;

import java.util.List;

public interface ClientDao {

    void save (ClientEntity clientEntity);

    void delete (Long idClient);

    void update (ClientEntity clientEntity);

    List<ClientEntity> findAll ();

    ClientEntity findById(Long idClient);

}
