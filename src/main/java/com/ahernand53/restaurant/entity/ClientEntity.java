package com.ahernand53.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "clients", schema = "restaurante_spring")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @NotNull
    @Column(name = "address")
    private String address;

    @Basic
    @NotNull
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "clientsByIdClient")
    @JsonIgnore
    private Collection<ReservationEntity> reservationsById;


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
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

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<ReservationEntity> getReservationsById () {
        return reservationsById;
    }

    public void setReservationsById (Collection<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
