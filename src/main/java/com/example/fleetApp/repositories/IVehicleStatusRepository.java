package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
}
