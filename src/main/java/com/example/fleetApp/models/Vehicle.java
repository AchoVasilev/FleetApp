package com.example.fleetApp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Long vehicleId;
    @ManyToOne
    private VehicleType vehicleType;
    private String vehicleNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date registrationDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date acquisitionDate;
    private String description;

    private Long vehicleMakeId;
    @ManyToOne
    private VehicleMake vehicleMake;

    private Double power;
    private Double fuelCapacity;

    private Long vehicleStatusId;
    @ManyToOne
    private VehicleStatus vehicleStatus;

    private Double netWeight;
    private String remarks;

    private Long employeeId;
    @ManyToOne
    private Employee inCharge;

    private Long vehicleModelId;
    @ManyToOne
    private VehicleModel vehicleModel;

    private Long locationId;
    @ManyToOne
    private Location location;

    public Long getId() {
        return id;
    }

    public Vehicle setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Vehicle setName(String name) {
        this.name = name;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Vehicle setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Vehicle setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Vehicle setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public Vehicle setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vehicle setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getVehicleMakeId() {
        return vehicleMakeId;
    }

    public Vehicle setVehicleMakeId(Long vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
        return this;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public Vehicle setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
        return this;
    }

    public Double getPower() {
        return power;
    }

    public Vehicle setPower(Double power) {
        this.power = power;
        return this;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public Vehicle setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public Long getVehicleStatusId() {
        return vehicleStatusId;
    }

    public Vehicle setVehicleStatusId(Long vehicleStatusId) {
        this.vehicleStatusId = vehicleStatusId;
        return this;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public Vehicle setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public Vehicle setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Vehicle setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Vehicle setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee getInCharge() {
        return inCharge;
    }

    public Vehicle setInCharge(Employee inCharge) {
        this.inCharge = inCharge;
        return this;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public Vehicle setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
        return this;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public Vehicle setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Vehicle setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Vehicle setLocation(Location location) {
        this.location = location;
        return this;
    }
}
