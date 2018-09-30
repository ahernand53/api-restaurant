package com.ahernand53.restaurant.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "types", schema = "restaurante_spring", catalog = "")
public class TypeEntity {
    private Integer id;
    private String name;
    private Collection<PlateEntity> platesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typesByIdType")
    public Collection<PlateEntity> getPlatesById () {
        return platesById;
    }

    public void setPlatesById (Collection<PlateEntity> platesById) {
        this.platesById = platesById;
    }
}
