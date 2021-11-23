package com.codegym.furama_case_study_final.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String educationName;
    @OneToMany(mappedBy = "education")
    private List<Employee> employeeList;

    public Education() {
    }

    public Education(Long id, String educationName, List<Employee> employeeList) {
        this.id = id;
        this.educationName = educationName;
        this.employeeList = employeeList;
    }

    public Education(String educationName, List<Employee> employeeList) {
        this.educationName = educationName;
        this.employeeList = employeeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
