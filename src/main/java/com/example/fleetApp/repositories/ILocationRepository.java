package com.example.fleetApp.repositories;

import com.example.fleetApp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
}
