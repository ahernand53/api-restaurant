package com.ahernand53.restaurant.repositories;

import com.ahernand53.restaurant.entity.TypeEntity;
import com.ahernand53.restaurant.repositories.interfaces.TypeDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TypeRepository extends AbstractSession implements TypeDao {

    @Override
    public void save (TypeEntity typeEntity) {
        getSession().persist(typeEntity);
    }

    @Override
    public void delete (Long idType) {
        TypeEntity typeEntity = findById(idType);
        if (typeEntity != null) {
            getSession().delete(typeEntity);
        }
    }

    @Override
    public void update (TypeEntity typeEntity) {
        getSession().update(typeEntity);
    }

    @Override
    public List<TypeEntity> findAll () {
        return getSession().createQuery("FROM TypeEntity ").list();
    }

    @Override
    public TypeEntity findById (Long idType) {
        return getSession().get(TypeEntity.class, idType);
    }

    @Override
    public TypeEntity findByIdPlate (Long idPlate) {
        List<Object[]> objects = getSession().createQuery(
                "SELECT ty.id, ty.name " +
                        "FROM TypeEntity ty " +
                        "JOIN PlateEntity pl ON ty.id = pl.typesByIdType.id " +
                        "WHERE pl.id = :idPlate "
        ).setParameter("idPlate", idPlate).list();

        if (objects.size() > 0) {
            for (Object object : objects) {
                if (object instanceof TypeEntity) {
                    return (TypeEntity) object;
                }
            }
        }

        return null;
    }
}
