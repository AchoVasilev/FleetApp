package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
