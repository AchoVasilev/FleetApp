package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleHireRepository extends JpaRepository<VehicleHire, Long> {
}
