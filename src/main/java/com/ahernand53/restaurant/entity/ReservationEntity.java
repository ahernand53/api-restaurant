package com.ahernand53.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations", schema = "restaurante_spring", catalog = "")
public class ReservationEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "date")
    private Integer date;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private ClientEntity clientsByIdClient;

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id")
    private TableEntity tablesByIdTable;

    @ManyToOne
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id")
    private WarehouseEntity warehouseByIdWarehouse;


    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getDate () {
        return date;
    }

    public void setDate (Integer date) {
        this.date = date;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode () {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public ClientEntity getClientsByIdClient () {
        return clientsByIdClient;
    }

    public void setClientsByIdClient (ClientEntity clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }

    public TableEntity getTablesByIdTable () {
        return tablesByIdTable;
    }

    public void setTablesByIdTable (TableEntity tablesByIdTable) {
        this.tablesByIdTable = tablesByIdTable;
    }

    public WarehouseEntity getWarehouseByIdWarehouse () {
        return warehouseByIdWarehouse;
    }

    public void setWarehouseByIdWarehouse (WarehouseEntity warehouseByIdWarehouse) {
        this.warehouseByIdWarehouse = warehouseByIdWarehouse;
    }
}
