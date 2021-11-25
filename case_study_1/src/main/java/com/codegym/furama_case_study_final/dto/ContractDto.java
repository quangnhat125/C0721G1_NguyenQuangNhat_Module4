package com.codegym.furama_case_study_final.dto;

import com.codegym.furama_case_study_final.model.ContractDetail;
import com.codegym.furama_case_study_final.model.Customer;
import com.codegym.furama_case_study_final.model.Employee;
import com.codegym.furama_case_study_final.model.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ContractDto implements Validator {

    private Long id;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for birthday 'DD/MM/YYYY'")
    private String startDate;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for birthday 'DD/MM/YYYY'")
    private String endDate;
    @Min(value = 1, message = "Deposit must be greater than 1!")
    private Double deposit;
    @Min(value = 1, message = "Total money must be greater than 1!")
    private Double totalMoney;

    private Customer customer;

    private Employee employee;

    private Service service;

    private List<ContractDetail> contractDetailList;

    public ContractDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
