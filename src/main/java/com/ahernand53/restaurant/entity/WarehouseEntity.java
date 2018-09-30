package com.ahernand53.restaurant.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "warehouse", schema = "restaurante_spring", catalog = "")
public class WarehouseEntity {
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private Integer numberTables;
    private Collection<ReservationEntity> reservationsById;
    private ChefHeadEntity chefHeadsByIdChefHead;

    @Id
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

    @Basic
    @Column(name = "phone")
    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "number_tables")
    public Integer getNumberTables () {
        return numberTables;
    }

    public void setNumberTables (Integer numberTables) {
        this.numberTables = numberTables;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehouseEntity that = (WarehouseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (numberTables != null ? !numberTables.equals(that.numberTables) : that.numberTables != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (numberTables != null ? numberTables.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "warehouseByIdWarehouse")
    public Collection<ReservationEntity> getReservationsById () {
        return reservationsById;
    }

    public void setReservationsById (Collection<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_chef_head", referencedColumnName = "id")
    public ChefHeadEntity getChefHeadsByIdChefHead () {
        return chefHeadsByIdChefHead;
    }

    public void setChefHeadsByIdChefHead (ChefHeadEntity chefHeadsByIdChefHead) {
        this.chefHeadsByIdChefHead = chefHeadsByIdChefHead;
    }
}
