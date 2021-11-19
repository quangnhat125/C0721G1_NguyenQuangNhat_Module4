package com.codegym.furamaresortcasestudy.model;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerCode;
    private String customerName;
    @Column(columnDefinition = "Date")
    private String customerBirthday;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String customerEmail;
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customer_type;

    public Customer() {
    }

    public Customer(Long id, String customerCode, String customerName, String customerBirthday,
                    int gender, String idCard, String phoneNumber, String customerEmail,
                    String customerAddress, CustomerType customer_type) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customer_type = customer_type;
    }

    public Customer(String customerCode, String customerName, String customerBirthday, int gender, String idCard,
                    String phoneNumber, String customerEmail, String customerAddress, CustomerType customer_type) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customer_type = customer_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(CustomerType customer_type) {
        this.customer_type = customer_type;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
