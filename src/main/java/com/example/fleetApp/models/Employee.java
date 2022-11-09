package com.example.fleetApp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String userName;

    private Long employeeTypeId;
    @ManyToOne
    @JoinColumn(name = "employeeTypeId", insertable = false, updatable = false)
    private EmployeeType employeeType;

    private Long jobTitleId;
    @ManyToOne
    @JoinColumn(name = "jobTitleId", insertable = false, updatable = false)
    private JobTitle jobTitle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date hireDate;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Employee setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Employee setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public Employee setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
        return this;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Employee setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
        return this;
    }

    public Long getJobTitleId() {
        return jobTitleId;
    }

    public Employee setJobTitleId(Long jobTitleId) {
        this.jobTitleId = jobTitleId;
        return this;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public Employee setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }
}
