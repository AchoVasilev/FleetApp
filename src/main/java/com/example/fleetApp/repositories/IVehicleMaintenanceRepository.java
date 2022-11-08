package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Long> {
}
