package com.ahernand53.restaurant.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tables", schema = "restaurante_spring", catalog = "")
public class TableEntity {
    private Integer id;
    private Integer tableNumber;
    private Collection<ReservationEntity> reservationsById;

    @Id
    @Column(name = "id")
    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "table_number")
    public Integer getTableNumber () {
        return tableNumber;
    }

    public void setTableNumber (Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableEntity that = (TableEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tableNumber != null ? !tableNumber.equals(that.tableNumber) : that.tableNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tableNumber != null ? tableNumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tablesByIdTable")
    public Collection<ReservationEntity> getReservationsById () {
        return reservationsById;
    }

    public void setReservationsById (Collection<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
