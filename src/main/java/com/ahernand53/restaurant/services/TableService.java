package com.ahernand53.restaurant.services;

import com.ahernand53.restaurant.entity.TableEntity;
import com.ahernand53.restaurant.repositories.interfaces.TableDao;
import com.ahernand53.restaurant.services.interfaces.TableServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tableService")
@Transactional
public class TableService implements TableServiceInterface {

    @Autowired
    private TableDao _tableDao;

    @Override
    public void save (TableEntity tableEntity) {
        _tableDao.save(tableEntity);
    }

    @Override
    public void delete (Long idTable) {
        _tableDao.delete(idTable);
    }

    @Override
    public void update (TableEntity tableEntity) {
        _tableDao.update(tableEntity);
    }

    @Override
    public List<TableEntity> findAll () {
        return _tableDao.findAll();
    }

    @Override
    public TableEntity findById (Long idTable) {
        return _tableDao.findById(idTable);
    }

    @Override
    public TableEntity findByIdReservation (Long idReservation) {
        return _tableDao.findByIdReservation(idReservation);
    }
}
