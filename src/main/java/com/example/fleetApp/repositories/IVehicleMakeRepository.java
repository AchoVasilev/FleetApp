package com.example.fleetApp.repositories;

import com.example.fleetApp.models.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleMakeRepository extends JpaRepository<VehicleMake, Long> {
}
