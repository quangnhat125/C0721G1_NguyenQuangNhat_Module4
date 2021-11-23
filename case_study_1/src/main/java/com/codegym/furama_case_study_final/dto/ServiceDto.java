package com.codegym.furama_case_study_final.dto;

import com.codegym.furama_case_study_final.model.Contract;
import com.codegym.furama_case_study_final.model.RentType;
import com.codegym.furama_case_study_final.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ServiceDto implements Validator {
    private Long id;
    @Pattern(regexp = "[D][V][-]\\d{4}", message = "Please enter the correct format for service code 'DV-XXXX' !")
    private String serviceCode;
    @NotBlank(message = "Service Name cannot be blank or empty!")
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private RentType rent_type;
    private ServiceType service_type;
    @NotBlank(message = "Standard Room cannot be blank or empty!")
    private String standardRoom;
    @NotBlank(message = "Description cannot be blank or empty!")
    private String description;
    private double poolArea;
    @Min(value = 1,message = "Number of floor must be more than 1 !")
    private int numberFloor;
    private List<Contract> contractList;

    public ServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRent_type() {
        return rent_type;
    }

    public void setRent_type(RentType rent_type) {
        this.rent_type = rent_type;
    }

    public ServiceType getService_type() {
        return service_type;
    }

    public void setService_type(ServiceType service_type) {
        this.service_type = service_type;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
