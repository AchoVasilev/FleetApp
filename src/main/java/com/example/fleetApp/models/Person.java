package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String title;
    private String initials;
    private String socialSecurityNumber;
    private String gender;
    private String maritalStatus;
    private String city;
    private String address;
    private String phone;
    private String mobile;
    private String email;
    private String photo;

    private Long countryId;
    @ManyToOne
    @JoinColumn(name="countryId", insertable=false, updatable=false)
    private Country country;

    private Long stateId;
    @ManyToOne
    @JoinColumn(name="stateId", insertable=false, updatable=false)
    private State state;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getOtherName() {
        return otherName;
    }

    public Person setOtherName(String otherName) {
        this.otherName = otherName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Person setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getInitials() {
        return initials;
    }

    public Person setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Person setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Person setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Person setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Person setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Person setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Person setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Person setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Long getStateId() {
        return stateId;
    }

    public Person setStateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }

    public State getState() {
        return state;
    }

    public Person setState(State state) {
        this.state = state;
        return this;
    }
}
