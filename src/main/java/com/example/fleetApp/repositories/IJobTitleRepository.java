package com.example.fleetApp.repositories;

import com.example.fleetApp.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobTitleRepository extends JpaRepository<JobTitle, Long> {
}
