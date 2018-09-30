package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.ClientEntity;
import com.ahernand53.restaurant.repositories.interfaces.ClientDao;
import com.ahernand53.restaurant.services.interfaces.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientService")
@Transactional
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientDao _clientDao;

    @Override
    public void save (ClientEntity clientEntity) {
        _clientDao.save(clientEntity);
    }

    @Override
    public void delete (Long idClient) {
        _clientDao.delete(idClient);
    }

    @Override
    public void update (ClientEntity clientEntity) {
        _clientDao.update(clientEntity);
    }

    @Override
    public List<ClientEntity> findAll () {
        return _clientDao.findAll();
    }

    @Override
    public ClientEntity findById (Long idClient) {
        return _clientDao.findById(idClient);
    }
}
