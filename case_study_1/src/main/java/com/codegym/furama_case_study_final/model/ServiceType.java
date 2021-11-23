package com.codegym.furama_case_study_final.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceTypeName;
    @OneToMany(mappedBy = "service_type")
    private Set<Service> serviceSet;

    public ServiceType() {
    }

    public ServiceType(Long id, String serviceTypeName, Set<Service> serviceSet) {
        this.id = id;
        this.serviceTypeName = serviceTypeName;
        this.serviceSet = serviceSet;
    }

    public ServiceType(String serviceTypeName, Set<Service> serviceSet) {
        this.serviceTypeName = serviceTypeName;
        this.serviceSet = serviceSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
