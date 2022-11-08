package com.example.fleetApp.repositories;

import com.example.fleetApp.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {
}
