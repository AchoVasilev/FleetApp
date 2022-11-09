package com.example.fleetApp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vehicle_maintenance")
public class VehicleMaintenance extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;
    @ManyToOne
    @JoinColumn(name="vehicleId", insertable=false, updatable=false)
    private Vehicle vehicle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

    private BigDecimal price;

    private Long supplierId;
    @ManyToOne
    @JoinColumn(name="supplierId", insertable=false, updatable=false)
    private Supplier supplier;

    private String remarks;

    public Long getId() {
        return id;
    }

    public VehicleMaintenance setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public VehicleMaintenance setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleMaintenance setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public VehicleMaintenance setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public VehicleMaintenance setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public VehicleMaintenance setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public VehicleMaintenance setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public VehicleMaintenance setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public VehicleMaintenance setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}
