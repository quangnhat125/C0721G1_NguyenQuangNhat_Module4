package com.codegym.furamaresortcasestudy.dto;

import com.codegym.furamaresortcasestudy.model.AttachService;
import com.codegym.furamaresortcasestudy.model.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;

public class ContractDetailDto implements Validator {
    private Long id;
    @Min(value = 1, message = "quantity must be greater than 1!")
    private int quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {}
}
