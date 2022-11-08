package com.example.fleetApp.repositories;

import com.example.fleetApp.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State, Long> {
}
