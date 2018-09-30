package com.ahernand53.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "plates", schema = "restaurante_spring", catalog = "")
public class PlateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private TypeEntity typesByIdType;


    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlateEntity that = (PlateEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public TypeEntity getTypesByIdType () {
        return typesByIdType;
    }

    public void setTypesByIdType (TypeEntity typesByIdType) {
        this.typesByIdType = typesByIdType;
    }
}
