package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.repositories.interfaces.ClientDao;
import com.ahernand53.restaurant.entity.ClientEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClientRepository extends AbstractSession implements ClientDao {

    @Override
    public void save (ClientEntity clientEntity) {
        getSession().persist(clientEntity);
    }

    @Override
    public void delete (Long idClient) {
        ClientEntity clientEntity = findById(idClient);
        if (clientEntity != null) {
            getSession().delete(clientEntity);
        }
    }

    @Override
    public void update (ClientEntity clientEntity) {
        getSession().update(clientEntity);
    }

    @Override
    public List<ClientEntity> findAll () {
        return getSession().createQuery("FROM ClientEntity ").list();
    }

    @Override
    public ClientEntity findById (Long idClient) {
        return getSession().get(ClientEntity.class, idClient);
    }

}
