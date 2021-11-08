package com.codegym.furamaresortcasestudy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customer_type")
public class CustomerType {
    @Id
    private Long id;
    private String customerType;
    @OneToMany(mappedBy = "customer_type")
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(Long id, String customerType, Set<Customer> customerSet) {
        this.id = id;
        this.customerType = customerType;
        this.customerSet = customerSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
