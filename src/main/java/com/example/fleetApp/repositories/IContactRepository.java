package com.example.fleetApp.repositories;

import com.example.fleetApp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
}
