package com.codegym.furama_case_study_final.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rentTypeName;
    @OneToMany(mappedBy = "rent_type")
    private Set<Service> serviceSet;

    public RentType() {
    }

    public RentType(Long id, String rentTypeName, Set<Service> serviceSet) {
        this.id = id;
        this.rentTypeName = rentTypeName;
        this.serviceSet = serviceSet;
    }

    public RentType(String rentTypeName, Set<Service> serviceSet) {
        this.rentTypeName = rentTypeName;
        this.serviceSet = serviceSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
