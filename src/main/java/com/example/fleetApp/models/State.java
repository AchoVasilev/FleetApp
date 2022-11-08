package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String capital;
    private String code;

    private Long countryId;
    @ManyToOne
    private Country country;

    private String details;
}
