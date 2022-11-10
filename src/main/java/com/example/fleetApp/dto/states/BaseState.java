package com.example.fleetApp.dto.states;

public abstract class BaseState {
    protected Long id;
    protected String name;
    protected String capital;
    protected String code;

    public BaseState(Long id, String name, String capital, String code) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
