package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_hire")
public class VehicleHire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

}
