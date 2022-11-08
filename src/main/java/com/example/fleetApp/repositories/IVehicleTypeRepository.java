package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
