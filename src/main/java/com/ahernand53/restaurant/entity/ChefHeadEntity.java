package com.ahernand53.restaurant.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chef_heads", schema = "restaurante_spring")
public class ChefHeadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "chefHeadsByIdChefHead")
    private Collection<WarehouseEntity> warehousesById;


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

    public String getLastname () {
        return lastname;
    }

    public void setLastname (String lastname) {
        this.lastname = lastname;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChefHeadEntity that = (ChefHeadEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<WarehouseEntity> getWarehousesById () {
        return warehousesById;
    }

    public void setWarehousesById (Collection<WarehouseEntity> warehousesById) {
        this.warehousesById = warehousesById;
    }
}
