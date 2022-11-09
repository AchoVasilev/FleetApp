package com.example.fleetApp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vehicle_hire")
public class VehicleHire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private Long vehicleId;
    @ManyToOne
    @JoinColumn(name="vehicleId", insertable=false, updatable=false)
    private Vehicle vehicle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOut;
    private String timeOut;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateIn;
    private String timeIn;

    private Long clientId;
    @ManyToOne
    @JoinColumn(name="clientId", insertable=false, updatable=false)
    private Client client;

    private Long locationId;
    @ManyToOne
    @JoinColumn(name="locationId", insertable=false, updatable=false)
    private Location location;

    private BigDecimal price;
    private String remarks;

    public Long getId() {
        return id;
    }

    public VehicleHire setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public VehicleHire setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleHire setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public VehicleHire setDateOut(Date dateOut) {
        this.dateOut = dateOut;
        return this;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public VehicleHire setTimeOut(String timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public VehicleHire setDateIn(Date dateIn) {
        this.dateIn = dateIn;
        return this;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public VehicleHire setTimeIn(String timeIn) {
        this.timeIn = timeIn;
        return this;
    }

    public Long getClientId() {
        return clientId;
    }

    public VehicleHire setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public VehicleHire setClient(Client client) {
        this.client = client;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public VehicleHire setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public VehicleHire setLocation(Location location) {
        this.location = location;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public VehicleHire setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public VehicleHire setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}
