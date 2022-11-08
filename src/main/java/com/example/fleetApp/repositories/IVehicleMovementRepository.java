package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleMovementRepository extends JpaRepository<VehicleMovement, Long> {
}
