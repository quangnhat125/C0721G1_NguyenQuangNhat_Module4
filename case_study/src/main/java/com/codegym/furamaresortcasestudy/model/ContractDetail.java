package com.codegym.furamaresortcasestudy.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract", referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attachService", referencedColumnName = "id")
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(int quantity, Contract contract, AttachService attachService) {
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
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
}
